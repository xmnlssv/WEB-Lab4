package com.nameless.lab4.services;

import com.nameless.lab4.entities.Point;
import com.nameless.lab4.repositories.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointService {

    private final PointRepository pointRepository;

    @Autowired
    public PointService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    public List<Point> findAllPoints() {
        return pointRepository.findAll();
    }

    public Point checkAndSavePoint(Point point) {
        return pointRepository.save(point);
    }

    public void deletePoints() {
        pointRepository.deleteAll();
    }
}
