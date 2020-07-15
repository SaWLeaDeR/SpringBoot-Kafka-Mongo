package com.example.deviceapi.domain.service;

import com.example.deviceapi.domain.model.dto.DeviceDto;
import java.util.List;

public interface DeviceLoadingService {

    List<DeviceDto> getAll();

    DeviceDto get(String id);

}
