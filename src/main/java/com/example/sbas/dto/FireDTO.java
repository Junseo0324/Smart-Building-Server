package com.example.sbas.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class FireDTO {
    //lombok 어노테이션으로 getter,setter,생성자,toString 메서드 생략 가능
    private Long id;
    private String flame;
    private String temperature;
    private String sensorTime;
}
