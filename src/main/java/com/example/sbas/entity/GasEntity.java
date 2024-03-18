package com.example.sbas.entity;

import com.example.sbas.dto.GasDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;
import org.json.JSONObject;

@Entity
@Getter
@Setter
@Table(name = "gas")
public class GasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String flammable;

    @Column
    private String co;

    @Column
    private String sensorTime;

    public static GasEntity togasEntity(GasDTO gasDTO){
        GasEntity gasEntity = new GasEntity();
        gasEntity.setId(gasDTO.getId());
        gasEntity.setFlammable(gasDTO.getFlammable());
        gasEntity.setCo(gasDTO.getCo());
        gasEntity.setSensorTime(gasDTO.getSensorTime());

        return gasEntity;
    }



    @Override
    public String toString() {

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",id);
        jsonObject.put("flammable",flammable);
        jsonObject.put("co",co);
        jsonObject.put("sensorTime",sensorTime);
        jsonArray.put(jsonObject);

        return jsonObject.toString() ;
    }
}
