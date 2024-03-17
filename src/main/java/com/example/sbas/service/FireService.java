package com.example.sbas.service;

import com.example.sbas.dto.FireDTO;
import com.example.sbas.entity.FireEntity;
import com.example.sbas.repository.FireRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //controller와 같이. final 멤버변수 생성자 만드는 역할

public class FireService {

    private final FireRepository fireRepository; // 먼저 jpa, mysql dependecy 추가

    public void save(FireDTO fireDTO){
        FireEntity fireEntity = FireEntity.tofireEntity(fireDTO);
        fireRepository.save(fireEntity);

    }

    public void firelist(FireDTO fireDTO){
        FireEntity fireEntity = FireEntity.tofireEntity(fireDTO);

    }
}
