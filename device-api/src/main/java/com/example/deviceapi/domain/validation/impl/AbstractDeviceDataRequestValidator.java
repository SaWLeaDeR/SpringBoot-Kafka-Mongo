package com.example.deviceapi.domain.validation.impl;

import com.example.deviceapi.domain.exception.DeviceException;
import com.example.deviceapi.domain.model.request.DeviceDataRequest;
import com.example.deviceapi.domain.validation.DeviceRequest;
import com.example.deviceapi.domain.validation.DeviceRequestValidator;
import java.util.Optional;

public abstract class AbstractDeviceDataRequestValidator implements DeviceRequestValidator {

    @Override
    public <T> Optional<DeviceException> validate(DeviceRequest<T> request) {

        final DeviceDataRequest deviceDataRequest = (DeviceDataRequest) request.getRequest();

        if (deviceDataRequest.getPressure() == null) {
            return Optional.of(new DeviceException("pressure-cannot-be-null"));
        }

        if (deviceDataRequest.getMoisture() == null) {
            return Optional.of(new DeviceException("moisture-can-not-be-null"));
        }

        if (deviceDataRequest.getAmbientTemperature() == null) {
            return Optional.of(new DeviceException("ambient-temperature-can-not-be-null"));
        }

        if (deviceDataRequest.getTemperature() == null) {
            return Optional.of(new DeviceException("temperature-can-not-be-null"));
        }

        if (deviceDataRequest.getTemperatureUnit() == null) {
            return Optional.of(new DeviceException("temperature-unit-can-not-be-null"));
        }

        if (deviceDataRequest.getUpTime() == null) {
            return Optional.of(new DeviceException("uptime-can-not-be-null"));
        }

        return Optional.empty();
    }

}
