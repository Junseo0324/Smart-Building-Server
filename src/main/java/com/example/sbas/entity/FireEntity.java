package com.example.sbas.entity;

import com.example.sbas.dto.FireDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
}
