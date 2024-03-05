package com.nameless.lab4.repositories;

import com.nameless.lab4.dto.User;
import com.nameless.lab4.entities.PointEntity;
import com.nameless.lab4.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PointRepository extends JpaRepository<PointEntity, Integer> {
    List<PointEntity> findAllByUserId(UserEntity user);

    void deleteAllByUserId(UserEntity user);
}
