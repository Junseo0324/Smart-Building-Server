package com.example.sbas.entity;

import com.example.sbas.dto.FireDTO;
import com.mysql.cj.xdevapi.JsonArray;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONObject;

@Entity
@Getter
@Setter
@Table(name = "fire")
public class FireEntity { //table 역할

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column
    private String flame;

    @Column
    private String temperature;

    @Column
    private String sensorTime;

    public static FireEntity tofireEntity(FireDTO fireDTO){
        FireEntity fireEntity = new FireEntity();
        fireEntity.setId(fireDTO.getId());
        fireEntity.setFlame(fireDTO.getFlame());
        fireEntity.setTemperature(fireDTO.getTemperature());
        fireEntity.setSensorTime(fireDTO.getSensorTime());

        return fireEntity;
    }


    @Override
    public String toString() {

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",id);
        jsonObject.put("flame",flame);
        jsonObject.put("temperature",temperature);
        jsonObject.put("sensorTime",sensorTime);
        jsonArray.put(jsonObject);

        return jsonObject.toString() ;
    }
}
