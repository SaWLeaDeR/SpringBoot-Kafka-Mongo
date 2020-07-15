package com.example.deviceapi.domain.model.converter;

import com.example.deviceapi.domain.model.document.DeviceDocument;
import com.example.deviceapi.domain.model.request.CreateDeviceRequest;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class CreateDeviceRequestConverter implements GenericConverter<CreateDeviceRequest, DeviceDocument> {

    @Override
    public DeviceDocument convert(CreateDeviceRequest source) {
        DeviceDocument target = new DeviceDocument();
        target.setName(source.getName());
        target.setActive(source.getActive());
        target.setVersion(source.getVersion());
        target.setLastMaintenanceDate(new Date());
        target.setCreatedAt(new Date());

        return target;
    }
}
