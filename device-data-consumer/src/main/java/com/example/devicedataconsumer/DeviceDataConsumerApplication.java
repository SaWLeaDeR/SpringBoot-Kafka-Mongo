package com.example.devicedataconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;


@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
public class DeviceDataConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeviceDataConsumerApplication.class, args);
    }
}

