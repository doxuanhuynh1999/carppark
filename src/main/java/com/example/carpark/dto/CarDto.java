package com.example.carpark.dto;

import com.example.carpark.entity.Parkinglot;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Data
public class CarDto {
    private String licensePlate;
    private String carColor;
    private String carType;
    private String company;
    private Long parkingId;
    public CarDto() {
    }
}
