package com.nameless.lab4.services;

import com.nameless.lab4.entities.PointEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AreaCheckerService {

    private double executionTimeMillis;

    public boolean pointInArea(PointEntity point) {
        double startTime = System.nanoTime();
        boolean result = checkArea(point.getX(), point.getY(), point.getR());
        double endTime = System.nanoTime();
        executionTimeMillis = (endTime - startTime) / 1000000;
        return result;
    }

    public boolean checkArea(Double x, Double y, Double r) {
        return checkRectangle(x, y, r) || checkTriangle(x, y, r) || checkSector(x, y, r);
    }

    // First quarter
    private boolean checkRectangle(Double x, Double y, Double r) {
        return (x >= 0 && y >= 0 && x <= r && y <= r / 2);
    }

    // Second quarter
    private boolean checkTriangle(Double x, Double y, Double r) {
        return ((x <= 0 && y >= 0 && x >= -r && y <= x + r));
    }

    // Four quarter
    private boolean checkSector(Double x, Double y, Double r) {
        return ((x >= 0) && (y <= 0) && (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r, 2)));
    }

    public double getExecutionTimeMillis() {
        return executionTimeMillis;
    }
}
