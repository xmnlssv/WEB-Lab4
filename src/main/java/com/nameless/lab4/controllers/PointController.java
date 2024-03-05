package com.nameless.lab4.controllers;

import com.nameless.lab4.dto.PointRequest;
import com.nameless.lab4.dto.PointResponse;
import com.nameless.lab4.services.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
    public List<PointResponse> findAll(Authentication authentication) {
        return pointService.findAllPoints(authentication.getName());
    }

    @PostMapping
    public PointResponse addPoint(@RequestBody PointRequest pointRequestDTO, Authentication authentication) {
        return pointService.addPoint(pointRequestDTO, authentication.getName());
    }

    @DeleteMapping
    public void deleteAllPoints(Authentication authentication) {
        pointService.deletePoints(authentication.getName());
    }
}
