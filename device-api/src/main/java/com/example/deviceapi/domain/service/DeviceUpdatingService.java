package com.example.deviceapi.domain.service;

import com.example.deviceapi.domain.model.dto.DeviceDto;
import com.example.deviceapi.domain.model.request.CreateDeviceRequest;
import com.example.deviceapi.domain.model.request.UpdateDeviceRequest;

public interface DeviceUpdatingService {

    DeviceDto save(CreateDeviceRequest device);

    DeviceDto update(String id, UpdateDeviceRequest device);
}
