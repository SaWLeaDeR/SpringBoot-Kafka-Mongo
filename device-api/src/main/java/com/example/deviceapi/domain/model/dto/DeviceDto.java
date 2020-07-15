package com.example.deviceapi.domain.model.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class DeviceDto implements Serializable {

    private static final long serialVersionUID = -1229772789521755906L;

    private String id;
    private String name;
    private String version;
    private Boolean active;
    private Date lastMaintenanceDate;
    private Date createdAt;
    private Date updatedAt;
}
