package com.example.sbas.repository;

import com.example.sbas.entity.FireEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FireRepository extends JpaRepository<FireEntity, Long> {
}
