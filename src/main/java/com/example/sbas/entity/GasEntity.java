package com.example.sbas.entity;

import com.example.sbas.dto.GasDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
}
