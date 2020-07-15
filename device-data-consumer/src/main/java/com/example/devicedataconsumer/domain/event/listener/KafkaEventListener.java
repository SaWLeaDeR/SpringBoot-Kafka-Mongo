package com.example.devicedataconsumer.domain.event.listener;

import com.example.devicedataconsumer.domain.event.model.DeviceDataEventDto;
import com.example.devicedataconsumer.domain.event.service.EventProcessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaEventListener {

    private static final Logger logger = LoggerFactory.getLogger(KafkaEventListener.class);
    private final EventProcessService service;

    public KafkaEventListener(EventProcessService service) {
        this.service = service;
    }


    @KafkaListener(topics = {"deviceData"},
        containerFactory = "listenerFactory")
    public void consumePromotionUpdateEvent(DeviceDataEventDto event) {

        if (event != null ) {
            service.process(event);
        } else {
            logger.error("Event Data is null");
        }
    }

}
