package com.nameless.lab4.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "points")
public class PointEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "x")
    private Double x;

    @Column(name = "y")
    private Double y;

    @Column(name = "r")
    private Double r;

    @Column(name = "result")
    private Boolean result;

    @Column(name = "current_time")
    private LocalDateTime currentTime;

    @Column(name = "execution_time")
    private Integer executionTime;

    public String getFormattedCurrentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return currentTime.format(formatter);
    }

    public String getFormattedIsArea() {
        return result ? "true" : "false";
    }
}
