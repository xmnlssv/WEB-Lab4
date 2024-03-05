package com.nameless.lab4.utils;

import com.nameless.lab4.dto.PointRequest;
import com.nameless.lab4.dto.PointResponse;
import com.nameless.lab4.entities.PointEntity;
import com.nameless.lab4.services.AreaCheckerService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class PointMapper {
    private final AreaCheckerService areaCheckerService;

    public PointMapper(AreaCheckerService areaCheckerService) {
        this.areaCheckerService = areaCheckerService;
    }

    public PointResponse mapToPointDTO(PointEntity point) {
        PointResponse dto = new PointResponse();
        dto.setX(point.getX());
        dto.setY(point.getY());
        dto.setR(point.getR());

        point.setResult(areaCheckerService.pointInArea(point));
        dto.setResult(point.getResult() ? "true" : "false");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        dto.setCurrentTime(point.getCurrentTime().format(formatter));

        dto.setExecutionTime(point.getExecutionTime());
        return dto;
    }

    public PointEntity mapToPointEntity(PointRequest dto) {
        PointEntity point = new PointEntity();
        point.setX(dto.getX());
        point.setY(dto.getY());
        point.setR(dto.getR());
        point.setResult(areaCheckerService.pointInArea(point));

        LocalDateTime currentTime = LocalDateTime.now();
        point.setCurrentTime(currentTime);

        point.setExecutionTime(areaCheckerService.getExecutionTimeMillis());

        return point;
    }
}
