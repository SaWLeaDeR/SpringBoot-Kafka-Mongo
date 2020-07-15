package com.example.devicedataconsumer.domain.service.dao.impl;

import com.example.devicedataconsumer.domain.repository.DeviceRepository;
import com.example.devicedataconsumer.domain.service.dao.DeviceDocumentDao;
import org.springframework.stereotype.Service;

@Service
public class DeviceDocumentDaoImpl implements DeviceDocumentDao {

    private final DeviceRepository deviceRepository;

    public DeviceDocumentDaoImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }
}
