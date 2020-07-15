package com.example.deviceapi.domain.service.impl;

import static java.util.Collections.singletonList;

import com.example.deviceapi.domain.model.converter.GenericConverter;
import com.example.deviceapi.domain.model.document.DeviceDocument;
import com.example.deviceapi.domain.model.dto.DeviceDto;
import com.example.deviceapi.domain.service.DeviceLoadingService;
import com.example.deviceapi.domain.service.dao.DeviceDocumentDao;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DeviceLoadingServiceImpl implements DeviceLoadingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceLoadingServiceImpl.class);

    private final GenericConverter<List<DeviceDocument>, List<DeviceDto>> converter;

    private final DeviceDocumentDao deviceDocumentDao;


    public DeviceLoadingServiceImpl(
        GenericConverter<List<DeviceDocument>, List<DeviceDto>> converter,
        DeviceDocumentDao deviceDocumentDao) {
        this.converter = converter;
        this.deviceDocumentDao = deviceDocumentDao;
    }

    @Override
    public List<DeviceDto> getAll() {
        return converter.convert(deviceDocumentDao.getAll());
    }

    @Override
    public DeviceDto get(String id) {
        return converter.convert(singletonList(deviceDocumentDao.get(id))).get(0);
    }
}
