package com.example.deviceapi.domain.service.dao;

import com.example.deviceapi.domain.model.document.DeviceDocument;
import com.example.deviceapi.domain.model.request.CreateDeviceRequest;
import com.example.deviceapi.domain.model.request.UpdateDeviceRequest;
import java.util.List;

public interface DeviceDocumentDao {

    List<DeviceDocument> getAll();

    DeviceDocument get(String id);

    DeviceDocument save(CreateDeviceRequest device);
    DeviceDocument update(String id, UpdateDeviceRequest device);

}
