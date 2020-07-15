package com.example.deviceapi.domain.validation.impl;

import com.example.deviceapi.domain.exception.DeviceException;
import com.example.deviceapi.domain.model.request.UpdateDeviceRequest;
import com.example.deviceapi.domain.validation.DeviceRequest;
import com.example.deviceapi.domain.validation.DeviceRequestValidator;
import java.util.Optional;

public abstract class AbstractUpdateDeviceRequestValidator implements DeviceRequestValidator {

    @Override
    public <T> Optional<DeviceException> validate(DeviceRequest<T> request) {
        final UpdateDeviceRequest updateDeviceRequest = (UpdateDeviceRequest) request.getRequest();

        if (updateDeviceRequest.getName() == null) {
            return Optional.of(new DeviceException("name-cannot-be-empty"));
        }

        if (updateDeviceRequest.getActive() == null) {
            return Optional.of(new DeviceException("active-can-not-be-empty"));
        }

        if (updateDeviceRequest.getVersion() == null) {
            return Optional.of(new DeviceException("device-version-can-not-be-empty"));
        }

        return Optional.empty();
    }
}
