package com.nameless.lab4.controllers;

import com.nameless.lab4.dto.PointRequestDTO;
import com.nameless.lab4.dto.PointResponseDTO;
import com.nameless.lab4.entities.PointEntity;
import com.nameless.lab4.services.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/points")
public class PointController {

    private final PointService pointService;

    @Autowired
    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    @GetMapping
    public List<PointResponseDTO> findAll() {
        return pointService.findAllPoints();
    }

    @PostMapping
    public PointResponseDTO addPoint(@RequestBody PointRequestDTO pointRequestDTO) {
        return pointService.addPoint(pointRequestDTO);
    }

    @DeleteMapping
    public void deleteAllPoints() {
        pointService.deletePoints();
    }
}
