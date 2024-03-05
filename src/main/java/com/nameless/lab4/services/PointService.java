package com.nameless.lab4.services;

import com.nameless.lab4.dto.PointRequest;
import com.nameless.lab4.dto.PointResponse;
import com.nameless.lab4.entities.PointEntity;
import com.nameless.lab4.entities.UserEntity;
import com.nameless.lab4.repositories.PointRepository;
import com.nameless.lab4.repositories.UserRepository;
import com.nameless.lab4.utils.PointMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PointService {

    private final PointRepository pointRepository;
    private final UserRepository userRepository;
    private final PointMapper pointMapper;

    @Autowired
    public PointService(PointRepository pointRepository, PointMapper pointMapper, UserRepository userRepository) {
        this.pointRepository = pointRepository;
        this.pointMapper = pointMapper;
        this.userRepository = userRepository;
    }

    public List<PointResponse> findAllPoints(String username) {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
        return pointRepository.findAllByUserId(user).stream()
                .map(pointMapper::mapToPointDTO)
                .collect(Collectors.toList());
    }

    public PointResponse addPoint(PointRequest pointRequestDTO, String username) {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
        PointEntity pointEntity = pointMapper.mapToPointEntity(pointRequestDTO);
        pointEntity.setUserId(user);
        PointEntity savedPoint = pointRepository.save(pointEntity);
        return pointMapper.mapToPointDTO(savedPoint);
    }

    @Transactional
    public void deletePoints(String username) {
        userRepository.findByUsername(username).ifPresent(pointRepository::deleteAllByUserId);
    }
}
