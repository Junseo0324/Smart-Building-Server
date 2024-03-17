package com.example.sbas.entity;

import com.example.sbas.dto.EarthquakeDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "earthquake")
public class EarthquakeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String vibrationSensor;

    @Column
    private String sensorTime;

    public static EarthquakeEntity toEarthquakeEntity(EarthquakeDTO earthquakeDTO){
        EarthquakeEntity earthquake = new EarthquakeEntity();
        earthquake.setId(earthquakeDTO.getId());
        earthquake.setVibrationSensor(earthquakeDTO.getVibrationSensor());
        earthquake.setSensorTime(earthquakeDTO.getSensorTime());

        return earthquake;
    }
}
