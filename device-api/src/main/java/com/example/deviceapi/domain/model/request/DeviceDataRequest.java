package com.example.deviceapi.domain.model.request;

import com.example.deviceapi.domain.model.enumeration.TemperatureUnit;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class DeviceDataRequest implements Serializable {

    private static final long serialVersionUID = -5655332176150092814L;

    private BigDecimal pressure;
    private BigDecimal moisture;
    private BigDecimal ambientTemperature;
    private BigDecimal temperature;
    private TemperatureUnit temperatureUnit;
    private Integer upTime;

}
