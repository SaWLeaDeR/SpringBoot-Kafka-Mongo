package com.example.deviceapi.domain.service.impl;

import com.example.deviceapi.domain.exception.DeviceException;
import com.example.deviceapi.domain.model.converter.DeviceDataRequestConverter;
import com.example.deviceapi.domain.model.dto.DeviceDataDto;
import com.example.deviceapi.domain.model.request.DeviceDataRequest;
import com.example.deviceapi.domain.service.DeviceDataService;
import com.example.deviceapi.domain.service.event.MessageService;
import com.example.deviceapi.domain.validation.DeviceRequest;
import com.example.deviceapi.domain.validation.DeviceRequestType;
import com.example.deviceapi.domain.validation.DeviceRequestValidator;
import com.example.deviceapi.domain.validation.factory.DeviceRequestValidatorFactory;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class DeviceDataServiceImpl implements DeviceDataService {

    private static final String TOPIC_NAME = "deviceData";

    private final DeviceDataRequestConverter converter;
    private final MessageService messageService;
    private final DeviceRequestValidatorFactory factory;

    public DeviceDataServiceImpl(DeviceDataRequestConverter converter, MessageService messageService,
        DeviceRequestValidatorFactory factory) {
        this.converter = converter;
        this.messageService = messageService;
        this.factory = factory;
    }

    @Override
    public void process(String id, DeviceDataRequest request) {
        final Optional<DeviceRequestValidator> deviceRequestValidator = factory.create(DeviceRequestType.DEVICE_DATA_REQUEST);

        if (!deviceRequestValidator.isPresent()){
            throw new DeviceException("validator-did't-found");
        }

        final Optional<DeviceException> deviceException = deviceRequestValidator.get().validate(new DeviceRequest<>(request));

        if (deviceException.isPresent()){
            throw deviceException.get();
        }

        final DeviceDataDto deviceData = converter.convert(id, request);

        messageService.send(TOPIC_NAME, deviceData);


    }
}
