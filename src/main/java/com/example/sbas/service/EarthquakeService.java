package com.example.sbas.service;


import com.example.sbas.dto.EarthquakeDTO;
import com.example.sbas.entity.EarthquakeEntity;
import com.example.sbas.repository.EarthquakeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EarthquakeService {

    private final EarthquakeRepository earthquakeRepository;

    public void save(EarthquakeDTO earthquakeDTO){
        EarthquakeEntity earthquake = EarthquakeEntity.toEarthquakeEntity(earthquakeDTO);
        earthquakeRepository.save(earthquake);
    }
}
