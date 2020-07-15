package com.example.devicedataconsumer.domain.configuration;

import static org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG;

import com.example.devicedataconsumer.domain.configuration.property.KafkaProperty;
import com.example.devicedataconsumer.domain.event.model.DeviceDataEventDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@EnableKafka
@Configuration
public class KafkaConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "kafka")
    public KafkaProperty getKafkaProperty() {
        return new KafkaProperty();
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, DeviceDataEventDto> listenerFactory(
        ConsumerFactory<String, DeviceDataEventDto> consumer) {
        ConcurrentKafkaListenerContainerFactory<String, DeviceDataEventDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumer);
        return factory;
    }

    @Bean
    public ConsumerFactory<String, DeviceDataEventDto> kafkaFactory(
        KafkaProperty kafkaProperty) {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperty.getBootstrapServers());
        config.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperty.getGroupId());
        config.put(KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(config,
            new StringDeserializer(),
            jsonDeserializer());
    }

    @Bean
    public JsonDeserializer<DeviceDataEventDto> jsonDeserializer(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return new JsonDeserializer<>(DeviceDataEventDto.class, objectMapper);
    }

}
