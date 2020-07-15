package com.example.devicedataconsumer.domain.event.service.impl;

import com.example.devicedataconsumer.domain.event.model.DeviceDataEventDto;
import com.example.devicedataconsumer.domain.event.service.EventProcessService;
import org.springframework.stereotype.Service;

@Service
public class EventProcessServiceImpl implements EventProcessService {

    @Override
    public void process(DeviceDataEventDto eventDto) {
        System.out.println(eventDto.toString());
    }
}
