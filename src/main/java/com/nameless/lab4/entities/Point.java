package com.nameless.lab4.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "points")
public class Point implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double x;

    private Double y;

    private Double r;

    private boolean result;

    @Column(name = "time")
    private Instant timestamp;

    @Column(name = "user_id")
    private Integer userId;

    public Point() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Point(Integer id, Double x, Double y, Double r, Instant timestamp, Integer userId) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.r = r;
        this.timestamp = timestamp;
        this.userId = userId;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
