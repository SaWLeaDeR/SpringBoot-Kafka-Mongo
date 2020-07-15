package com.example.deviceapi.domain.model.request;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateDeviceRequest implements Serializable {

    private static final long serialVersionUID = -8786692507411930128L;

    @NotNull(message = "device-name-should-be-given")
    private String name;
    @NotNull(message = "device-version-should-be-given")
    private String version;
    @NotNull(message = "device-active-should-be-given")
    private Boolean active;
}
