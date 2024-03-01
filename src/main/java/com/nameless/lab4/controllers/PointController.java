package com.nameless.lab4.controllers;

import com.nameless.lab4.dto.PointRequest;
import com.nameless.lab4.dto.PointResponse;
import com.nameless.lab4.services.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/points")
public class PointController {

    private final PointService pointService;

    @Autowired
    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    @GetMapping
    public List<PointResponse> findAll() {
        return pointService.findAllPoints();
    }

    @PostMapping
    public PointResponse addPoint(@RequestBody PointRequest pointRequestDTO) {
        return pointService.addPoint(pointRequestDTO);
    }

    @DeleteMapping
    public void deleteAllPoints() {
        pointService.deletePoints();
    }
}
