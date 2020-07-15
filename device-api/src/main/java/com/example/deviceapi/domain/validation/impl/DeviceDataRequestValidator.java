package com.example.deviceapi.domain.validation.impl;

import com.example.deviceapi.domain.validation.DeviceRequestType;
import org.springframework.stereotype.Component;

@Component
public class DeviceDataRequestValidator extends AbstractDeviceDataRequestValidator {

    @Override
    public boolean matches(DeviceRequestType requestType) {
        return DeviceRequestType.DEVICE_DATA_REQUEST.equals(requestType);
    }
}
