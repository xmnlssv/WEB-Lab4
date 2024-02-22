package com.nameless.lab4.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PointDTO {

    private Integer id;

    @NotNull
    @Min(value = -5, message = "Min value for X is -5")
    @Max(value = 5, message = "Max value for X is 3")
    private Double x;

    @NotNull
    @Min(value = -5, message = "Min value for Y is -5")
    @Max(value = 3, message = "Max value for Y is 3")
    private Double y;

    @NotNull
    @Min(value = 0, message = "Min value for R is 0+")
    @Max(value = 3, message = "Max value for R is 3")
    private Double r;

    private String result;

    private String currentTime;

    private int executionTime;
}
