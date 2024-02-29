package com.nameless.lab4.repositories;

import com.nameless.lab4.entities.PointEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepository extends JpaRepository<PointEntity, Integer> {
}
