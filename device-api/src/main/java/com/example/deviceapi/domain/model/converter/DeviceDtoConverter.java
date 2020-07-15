package com.example.deviceapi.domain.model.converter;

import com.example.deviceapi.domain.model.document.DeviceDocument;
import com.example.deviceapi.domain.model.dto.DeviceDto;
import org.springframework.stereotype.Component;

@Component
public class DeviceDtoConverter implements GenericConverter<DeviceDto, DeviceDocument>{

    @Override
    public DeviceDocument convert(DeviceDto source) {
        DeviceDocument target = new DeviceDocument();
        target.setName(source.getName());
        target.setVersion(source.getVersion());
        target.setActive(source.getActive());
        target.setLastMaintenanceDate(source.getLastMaintenanceDate());
        target.setCreatedAt(source.getCreatedAt());
        target.setUpdatedAt(source.getUpdatedAt());
        return target;
    }
}
