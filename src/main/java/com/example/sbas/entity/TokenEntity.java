package com.example.sbas.entity;

import com.example.sbas.dto.TokenDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="token")
public class TokenEntity { //table 역할
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String token;

    public static TokenEntity totokenEntity(TokenDTO tokenDTO){
        TokenEntity tokenEntity = new TokenEntity();
        tokenEntity.setId(tokenDTO.getId());
        tokenEntity.setToken(tokenDTO.getToken());

        return tokenEntity;
    }
}
