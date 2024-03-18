package com.example.sbas.entity;

import com.example.sbas.dto.EarthquakeDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONObject;

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



    @Override
    public String toString() {

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",id);
        jsonObject.put("vibrationSensor",vibrationSensor);
        jsonObject.put("sensorTime",sensorTime);
        jsonArray.put(jsonObject);

        return jsonObject.toString() ;
    }
}
