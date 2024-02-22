package com.nameless.lab4.utils;

import com.nameless.lab4.dto.PointDTO;
import com.nameless.lab4.entities.PointEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PointMapper {

    public PointDTO mapToPointDTO(PointEntity point){
        PointDTO dto = new PointDTO();
        dto.setId(point.getId());
        dto.setX(point.getX());
        dto.setY(point.getY());
        dto.setR(point.getR());
        dto.setResult(point.getFormattedIsArea());
        dto.setCurrentTime(point.getFormattedCurrentTime());
        dto.setExecutionTime(point.getExecutionTime());
        return dto;
    }

    public PointEntity mapToPointEntity(PointDTO dto){

        PointEntity point = new PointEntity();
        point.setId(dto.getId());
        point.setX(dto.getX());
        point.setY(dto.getY());
        point.setR(dto.getR());
        point.setResult(Boolean.parseBoolean(dto.getResult()));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        if (dto.getCurrentTime() != null && !dto.getCurrentTime().isEmpty()) {
            point.setCurrentTime(LocalDateTime.parse(dto.getCurrentTime(), formatter));
        }

        point.setExecutionTime(dto.getExecutionTime());

        return point;
    }
}
