package com.example.deviceapi.domain.service;

import com.example.deviceapi.domain.model.request.DeviceDataRequest;

public interface DeviceDataService {

    void process(String id, DeviceDataRequest request);
}
