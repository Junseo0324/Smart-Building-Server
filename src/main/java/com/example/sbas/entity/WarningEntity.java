package com.example.sbas.entity;

import com.example.sbas.dto.WarningDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="warning")
public class WarningEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String warningId;

    public static WarningEntity toWarningEntity(WarningDTO warningDTO){
        WarningEntity warningEntity = new WarningEntity();
        warningEntity.setId(warningDTO.getId());
        warningEntity.setWarningId(warningDTO.getWarningId());

        return warningEntity;
    }
}
