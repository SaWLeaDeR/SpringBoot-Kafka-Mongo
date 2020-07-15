package com.example.deviceapi.domain.model.document;

import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "device")
public class DeviceDocument {

    @Id
    private String id;
    private String name;
    private String version;
    private Boolean active;
    private Date lastMaintenanceDate;
    private Date createdAt;
    private Date updatedAt;

}
