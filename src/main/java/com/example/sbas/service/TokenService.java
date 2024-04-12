package com.example.sbas.service;

import com.example.sbas.dto.TokenDTO;
import com.example.sbas.entity.TokenEntity;
import com.example.sbas.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final TokenRepository tokenRepository;

    public String save(TokenDTO tokenDTO){
        TokenEntity tokenEntity = TokenEntity.totokenEntity(tokenDTO);
        TokenEntity entity = tokenRepository.save(tokenEntity);
        return entity.getToken();
    }
}
