package com.example.devicedataconsumer.domain.event.service;

import com.example.devicedataconsumer.domain.event.model.DeviceDataEventDto;

public interface EventProcessService {

    void process(DeviceDataEventDto eventDto);

}
