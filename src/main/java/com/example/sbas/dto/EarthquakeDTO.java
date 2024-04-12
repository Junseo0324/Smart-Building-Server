package com.example.sbas.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@NoArgsConstructor
@ToString
@Getter
public class EarthquakeDTO {
    private Long id;
    private String vibrationSensor;
    private String sensorTime;
}
