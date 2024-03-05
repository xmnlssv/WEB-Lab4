package com.nameless.lab4.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PointResponse {

    @NotNull(message = "Значение X не может быть пустым")
    @Min(value = -5, message = "Минимальное значение для X — -5")
    @Max(value = 5, message = "Максимальное значение для X — 5")
    private Double x;

    @NotNull(message = "Значение Y не может быть пустым")
    @Min(value = -5, message = "Минимальное значение для Y — -5")
    @Max(value = 3, message = "Максимальное значение для Y — 3")
    private Double y;

    @NotNull(message = "Значение R не может быть пустым")
    @Min(value = 0, message = "Минимальное значение для R — 0+")
    @Max(value = 3, message = "Максимальное значение для R — 3")
    private Double r;

    @NotNull
    private String result;

    @NotNull
    private String currentTime;

    @NotNull
    private Double executionTime;
}
