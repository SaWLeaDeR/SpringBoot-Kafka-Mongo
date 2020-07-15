package com.example.devicedataconsumer.domain.event.model;

import com.example.devicedataconsumer.domain.event.deserializer.DateDeserializer;
import com.example.devicedataconsumer.domain.model.dto.DeviceDataParametersDto;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import lombok.Data;

@Data
public class DeviceDataEventDto implements Serializable {

    private static final long serialVersionUID = -6227143204355069960L;

    private String id;
    private DeviceDataParametersDto parameters;
    @JsonDeserialize(using = DateDeserializer.class)
    private Date date;
    private Timestamp timeStamp;
}
