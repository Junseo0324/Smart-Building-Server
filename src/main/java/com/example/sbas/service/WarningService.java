package com.example.sbas.service;


import com.example.sbas.dto.WarningDTO;
import com.example.sbas.entity.WarningEntity;
import com.example.sbas.repository.WarningRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WarningService {

    public final WarningRepository warningRepository;

    public void save(WarningDTO warningDTO){
        WarningEntity warningEntity = WarningEntity.toWarningEntity(warningDTO);

        warningRepository.save(warningEntity);
    }
}
