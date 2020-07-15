package com.example.deviceapi.domain.service.event;

public interface MessageService {

    void send(String topicName, Object message);

}
