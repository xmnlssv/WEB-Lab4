package com.nameless.lab4.controllers;

import com.nameless.lab4.entities.Point;
import com.nameless.lab4.repositories.PointRepository;
import com.nameless.lab4.services.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/points")
public class PointController {

    private PointService pointService;

    @Autowired
    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    @GetMapping
    public List<Point> findAll() {
        return pointService.findAllPoints();
    }

    @PostMapping
    public Point add(@RequestBody Point point) {
        return pointService.checkAndSavePoint(point);
    }

    @DeleteMapping
    public void deleteAll() {
        pointService.deletePoints();
    }
}
