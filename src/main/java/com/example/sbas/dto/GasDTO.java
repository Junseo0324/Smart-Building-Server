package com.example.sbas.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class GasDTO {
    private Long id;
    private String flammable;
    private String co;
    private String sensorTime;
}
