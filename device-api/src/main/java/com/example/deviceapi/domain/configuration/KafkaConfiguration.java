package com.example.deviceapi.domain.configuration;

import com.example.deviceapi.domain.configuration.property.KafkaProperties;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfiguration {

    @Bean("kafkaProducerProperties")
    @ConfigurationProperties(prefix = "kafka")
    public KafkaProperties kafkaProducerProperties() {
        return new KafkaProperties();
    }

    @Bean(name = "kafkaProducer")
    public KafkaProducer<String, String> createProducer(@Qualifier(value = "kafkaProducerProperties")
        KafkaProperties kafkaProperties)  {

        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, kafkaProperties.getKeySerializer());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, kafkaProperties.getValueSerializer());

        return new KafkaProducer<>(properties);
    }

}
