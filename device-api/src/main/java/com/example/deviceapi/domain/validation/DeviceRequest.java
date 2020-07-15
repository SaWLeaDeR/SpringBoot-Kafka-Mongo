package com.example.deviceapi.domain.validation;

public class DeviceRequest<T> {

    private T request;

    public DeviceRequest(T request) {
        this.request = request;
    }

    public T getRequest() {
        return request;
    }

    public void setRequest(T request) {
        this.request = request;
    }
}
