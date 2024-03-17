package com.example.sbas.repository;

import com.example.sbas.entity.EarthquakeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EarthquakeRepository extends JpaRepository<EarthquakeEntity,Long> {
}
