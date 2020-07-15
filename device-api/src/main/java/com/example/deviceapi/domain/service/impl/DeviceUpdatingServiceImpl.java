package com.example.deviceapi.domain.service.impl;

import static java.util.Collections.singletonList;

import com.example.deviceapi.domain.exception.DeviceException;
import com.example.deviceapi.domain.model.converter.GenericConverter;
import com.example.deviceapi.domain.model.document.DeviceDocument;
import com.example.deviceapi.domain.model.dto.DeviceDto;
import com.example.deviceapi.domain.model.request.CreateDeviceRequest;
import com.example.deviceapi.domain.model.request.UpdateDeviceRequest;
import com.example.deviceapi.domain.service.DeviceUpdatingService;
import com.example.deviceapi.domain.service.dao.DeviceDocumentDao;
import com.example.deviceapi.domain.validation.DeviceRequest;
import com.example.deviceapi.domain.validation.DeviceRequestType;
import com.example.deviceapi.domain.validation.DeviceRequestValidator;
import com.example.deviceapi.domain.validation.factory.DeviceRequestValidatorFactory;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class DeviceUpdatingServiceImpl implements DeviceUpdatingService {

    private final GenericConverter<List<DeviceDocument>, List<DeviceDto>> dtoConverter;
    private final DeviceRequestValidatorFactory factory;
    private final DeviceDocumentDao deviceDocumentDao;

    public DeviceUpdatingServiceImpl(
        GenericConverter<List<DeviceDocument>, List<DeviceDto>> dtoConverter,
        DeviceRequestValidatorFactory factory, DeviceDocumentDao deviceDocumentDao) {
        this.dtoConverter = dtoConverter;
        this.factory = factory;
        this.deviceDocumentDao = deviceDocumentDao;
    }

    @Override
    public DeviceDto save(CreateDeviceRequest request) {
        final DeviceDocument deviceDocument = deviceDocumentDao.save(request);
        if (deviceDocument == null){
            throw new DeviceException("Problem has occurs while create device");
        }
        return dtoConverter.convert(singletonList(deviceDocument)).get(0);

    }

    @Override
    public DeviceDto update(String id, UpdateDeviceRequest request) {
        final Optional<DeviceRequestValidator> updateRequestValidator = factory.create(DeviceRequestType.UPDATE_DEVICE_REQUEST);
        if (!updateRequestValidator.isPresent()){
            throw new DeviceException("validator-did't-found");
        }

        final Optional<DeviceException> deviceException = updateRequestValidator.get().validate(new DeviceRequest<>(request));
        if (deviceException.isPresent()){
            throw deviceException.get();
        }

        return dtoConverter.convert(singletonList(deviceDocumentDao.update(id, request))).get(0);
    }
}
