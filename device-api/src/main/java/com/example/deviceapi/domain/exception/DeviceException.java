package com.example.deviceapi.domain.exception;

public class DeviceException extends RuntimeException {

    private static final long serialVersionUID = -3651722455605984714L;

    public DeviceException(String message) {
        super(message);
    }
}
