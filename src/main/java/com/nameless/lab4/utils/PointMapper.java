package com.nameless.lab4.utils;

import com.nameless.lab4.dto.PointRequestDTO;
import com.nameless.lab4.dto.PointResponseDTO;
import com.nameless.lab4.entities.PointEntity;
import com.nameless.lab4.services.AreaCheckerService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Service
public class PointMapper {

    private final AreaCheckerService areaCheckerService;

    public PointMapper(AreaCheckerService areaCheckerService) {
        this.areaCheckerService = areaCheckerService;
    }

    public PointResponseDTO mapToPointDTO(PointEntity point) {
        PointResponseDTO dto = new PointResponseDTO();
        dto.setX(point.getX());
        dto.setY(point.getY());
        dto.setR(point.getR());

        point.setResult(areaCheckerService.pointInArea(point));
        dto.setResult(point.getFormattedIsArea());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        dto.setCurrentTime(point.getCurrentTime().format(formatter));

        dto.setExecutionTime(point.getExecutionTime());
        return dto;
    }

    public PointEntity mapToPointEntity(PointRequestDTO dto) {


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
