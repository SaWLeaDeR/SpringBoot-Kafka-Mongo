package com.example.deviceapi.domain.model.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import lombok.Data;

@Data
public class DeviceDataDto implements Serializable {

    private static final long serialVersionUID = -1992186890555878221L;

    private String id;
    private DeviceDataParametersDto parameters;
    private Date date;
    private Timestamp timeStamp;

}
