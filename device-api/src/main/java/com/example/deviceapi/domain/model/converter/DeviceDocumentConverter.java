package com.example.deviceapi.domain.model.converter;

import com.example.deviceapi.domain.model.document.DeviceDocument;
import com.example.deviceapi.domain.model.dto.DeviceDto;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class DeviceDocumentConverter implements GenericConverter<List<DeviceDocument>, List<DeviceDto>>{


    @Override
    public List<DeviceDto> convert(List<DeviceDocument> source) {

        return source.stream()
            .filter(Objects::nonNull)
            .map(this::convertSingleDevice)
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(Collectors.toList());
    }

    public Optional<DeviceDto> convertSingleDevice(DeviceDocument source) {
        if (source == null) {
            return Optional.empty();
        }

        DeviceDto target = new DeviceDto();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setVersion(source.getVersion());
        target.setActive(source.getActive());
        target.setLastMaintenanceDate(source.getLastMaintenanceDate());
        target.setCreatedAt(source.getCreatedAt());
        target.setUpdatedAt(source.getUpdatedAt());
        return Optional.of(target);
    }
}
