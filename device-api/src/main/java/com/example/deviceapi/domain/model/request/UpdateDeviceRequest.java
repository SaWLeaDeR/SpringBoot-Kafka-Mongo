package com.example.deviceapi.domain.model.request;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class UpdateDeviceRequest implements Serializable {

    private static final long serialVersionUID = -8917583679076349060L;

    private String name;
    private String version;
    private Boolean active;
    private Date createdAt;
}
