package com.example.sbas.service;


import com.example.sbas.dto.GasDTO;
import com.example.sbas.entity.GasEntity;
import com.example.sbas.repository.GasRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GasService {

    private final GasRepository gasRepository;

    public void save(GasDTO gasDTO){
        GasEntity gasEntity = GasEntity.togasEntity(gasDTO);
        gasRepository.save(gasEntity);

    }

    public String findList() {

        List<GasEntity> dbList = gasRepository.findAll();

        return dbList.toString();
    }
}
