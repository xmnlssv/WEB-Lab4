package com.nameless.lab4.services;

import com.nameless.lab4.dto.PointRequest;
import com.nameless.lab4.dto.PointResponse;
import com.nameless.lab4.entities.PointEntity;
import com.nameless.lab4.repositories.PointRepository;
import com.nameless.lab4.utils.PointMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PointService {

    private final PointRepository pointRepository;
    private final PointMapper pointMapper;

    @Autowired
    public PointService(PointRepository pointRepository, PointMapper pointMapper) {
        this.pointRepository = pointRepository;
        this.pointMapper = pointMapper;
    }

    public List<PointResponse> findAllPoints() {
        return pointRepository.findAll().stream()
                .map(pointMapper::mapToPointDTO)
                .collect(Collectors.toList());
    }

    public PointResponse addPoint(PointRequest pointRequestDTO) {
        PointEntity pointEntity = pointMapper.mapToPointEntity(pointRequestDTO);
        PointEntity savedPoint = pointRepository.save(pointEntity);
        return pointMapper.mapToPointDTO(savedPoint);

    }

    public void deletePoints() {
        pointRepository.deleteAll();
    }
}
