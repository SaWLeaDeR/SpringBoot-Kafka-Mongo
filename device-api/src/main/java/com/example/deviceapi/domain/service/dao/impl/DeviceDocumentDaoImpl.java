package com.example.deviceapi.domain.service.dao.impl;

import com.example.deviceapi.domain.exception.DeviceException;
import com.example.deviceapi.domain.model.converter.GenericConverter;
import com.example.deviceapi.domain.model.document.DeviceDocument;
import com.example.deviceapi.domain.model.request.CreateDeviceRequest;
import com.example.deviceapi.domain.model.request.UpdateDeviceRequest;
import com.example.deviceapi.domain.repository.DeviceRepository;
import com.example.deviceapi.domain.service.dao.DeviceDocumentDao;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class DeviceDocumentDaoImpl implements DeviceDocumentDao {

    private final DeviceRepository deviceRepository;
    private final GenericConverter<CreateDeviceRequest, DeviceDocument> createDeviceRequestConverter;
    private final GenericConverter<UpdateDeviceRequest, DeviceDocument> updateDeviceRequestConverter;

    public DeviceDocumentDaoImpl(DeviceRepository deviceRepository,
        GenericConverter<CreateDeviceRequest, DeviceDocument> createDeviceRequestConverter,
        GenericConverter<UpdateDeviceRequest, DeviceDocument> updateDeviceRequestConverter) {
        this.deviceRepository = deviceRepository;
        this.createDeviceRequestConverter = createDeviceRequestConverter;
        this.updateDeviceRequestConverter = updateDeviceRequestConverter;
    }

    @Override
    public List<DeviceDocument> getAll() {
        return deviceRepository.findAll();
    }

    @Override
    public DeviceDocument get(String id) {
        final Optional<DeviceDocument> deviceDocumentOptional = deviceRepository.findById(id);
        if (deviceDocumentOptional.isPresent()) {
            return deviceDocumentOptional.get();
        }
        throw new DeviceException("Invalid Device Id");
    }

    @Override
    public DeviceDocument save(CreateDeviceRequest device) {
        return deviceRepository.save(createDeviceRequestConverter.convert(device));
    }

    @Override
    public DeviceDocument update(String id, UpdateDeviceRequest device) {
        final DeviceDocument deviceDocument = get(id);

        if (deviceDocument == null) {
            throw new DeviceException("Invalid Device Id");
        }

        final DeviceDocument requestDevice = updateDeviceRequestConverter.convert(device);
        requestDevice.setId(deviceDocument.getId());
        if (requestDevice.getCreatedAt() == null) {
            requestDevice.setCreatedAt(deviceDocument.getCreatedAt());
        }
        return deviceRepository.save(requestDevice);
    }
}
