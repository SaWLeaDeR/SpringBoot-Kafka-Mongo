package com.example.deviceapi.domain.model.converter;

import com.example.deviceapi.domain.model.dto.DeviceDataDto;
import com.example.deviceapi.domain.model.dto.DeviceDataParametersDto;
import com.example.deviceapi.domain.model.request.DeviceDataRequest;
import java.sql.Timestamp;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class DeviceDataRequestConverter {

    public DeviceDataDto convert(String id, DeviceDataRequest source) {
        DeviceDataDto target = new DeviceDataDto();
        target.setId(id);
        target.setParameters(convertParameters(source));
        target.setDate(new Date());
        target.setTimeStamp(Timestamp.from(new Date().toInstant()));
        return target;
    }

    private DeviceDataParametersDto convertParameters(DeviceDataRequest source) {
        DeviceDataParametersDto target = new DeviceDataParametersDto();
        target.setPressure(source.getPressure());
        target.setMoisture(source.getMoisture());
        target.setAmbientTemperature(source.getAmbientTemperature());
        target.setTemperature(source.getTemperature());
        target.setTemperatureUnit(source.getTemperatureUnit());
        target.setUpTime(source.getUpTime());
        return target;
    }
}
