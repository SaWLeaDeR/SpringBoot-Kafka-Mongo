package com.example.deviceapi.domain.model.converter;

import com.example.deviceapi.domain.model.document.DeviceDocument;
import com.example.deviceapi.domain.model.request.UpdateDeviceRequest;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class UpdateDeviceRequestConverter implements GenericConverter<UpdateDeviceRequest, DeviceDocument> {

    @Override
    public DeviceDocument convert(UpdateDeviceRequest source) {
        DeviceDocument target = new DeviceDocument();
        target.setName(source.getName());
        target.setActive(source.getActive());
        target.setVersion(source.getVersion());
        target.setLastMaintenanceDate(new Date());
        target.setCreatedAt(source.getCreatedAt());
        target.setUpdatedAt(new Date());
        return target;
    }
}
