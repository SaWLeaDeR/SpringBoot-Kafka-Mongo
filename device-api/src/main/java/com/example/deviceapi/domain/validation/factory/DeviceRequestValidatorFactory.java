package com.example.deviceapi.domain.validation.factory;

import com.example.deviceapi.domain.validation.DeviceRequestType;
import com.example.deviceapi.domain.validation.DeviceRequestValidator;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class DeviceRequestValidatorFactory {

    private List<DeviceRequestValidator> validators;

    public DeviceRequestValidatorFactory(List<DeviceRequestValidator> validators) {
        this.validators = validators;
    }

    public Optional<DeviceRequestValidator> create(DeviceRequestType requestType) {

        for (DeviceRequestValidator validator : validators) {
            if (validator.matches(requestType)) {
                return Optional.of(validator);
            }
        }
        return Optional.empty();
    }

}
