package com.example.deviceapi.domain.validation;

import com.example.deviceapi.domain.exception.DeviceException;
import java.util.Optional;

public interface DeviceRequestValidator {

    <T> Optional<DeviceException> validate(DeviceRequest<T> request);

    boolean matches(DeviceRequestType requestType);
}
