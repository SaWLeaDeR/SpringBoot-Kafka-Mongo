package com.example.devicedataconsumer.domain.model.dto;

import com.example.devicedataconsumer.domain.model.enumeration.TemperatureUnit;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class DeviceDataParametersDto implements Serializable {

    private static final long serialVersionUID = -1172352383852846859L;

    private BigDecimal pressure;
    private BigDecimal moisture;
    private BigDecimal ambientTemperature;
    private BigDecimal temperature;
    private TemperatureUnit temperatureUnit;
    private Integer upTime;

}
