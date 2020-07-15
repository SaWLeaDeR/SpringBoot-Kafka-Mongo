package com.example.deviceapi.domain.service.event.impl;

import com.example.deviceapi.domain.service.event.MessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.annotation.PreDestroy;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ObjectMapper objectMapper;
    private KafkaProducer<String, String> kafkaProducer;

    protected MessageServiceImpl(
        @Qualifier(value = "kafkaProducer") KafkaProducer<String, String> kafkaProducer,
        ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.kafkaProducer = kafkaProducer;
    }

    @Override
    public void send(String topicName, Object message) {
        String event;
        try {
            event = objectMapper.writeValueAsString(message);
            kafkaProducer().send(new ProducerRecord<>(topicName, event));
            logger.info("topic={} has been successfully sent data as data={}", topicName, event);

        } catch (JsonProcessingException e) {
            logger.error("topic={} parseErrorMessage={}", topicName, e.getMessage());
        }
    }

    @PreDestroy
    public void shutdown() {
        kafkaProducer().close();
    }


    public KafkaProducer<String, String> kafkaProducer() {
        return kafkaProducer;
    }
}
