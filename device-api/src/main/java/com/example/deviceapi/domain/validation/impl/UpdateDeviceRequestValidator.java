package com.example.deviceapi.domain.validation.impl;

import com.example.deviceapi.domain.validation.DeviceRequestType;
import org.springframework.stereotype.Component;

@Component
public class UpdateDeviceRequestValidator extends AbstractUpdateDeviceRequestValidator {

    @Override
    public boolean matches(DeviceRequestType requestType) {
        return DeviceRequestType.UPDATE_DEVICE_REQUEST.equals(requestType);
    }
}
