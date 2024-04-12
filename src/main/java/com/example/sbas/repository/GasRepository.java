package com.example.sbas.repository;

import com.example.sbas.entity.GasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GasRepository extends JpaRepository<GasEntity,Long> {
}
