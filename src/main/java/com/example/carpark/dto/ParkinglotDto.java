package com.example.carpark.dto;

import lombok.Data;

import javax.persistence.Column;
import java.util.List;
import java.util.Set;

@Data
public class ParkinglotDto {
    private Long parkId;
    private Long parkArea;
    private String parkName;
    private String parkPlace;
    private Long parkPrice;
    private String parkStatus;
//    private List<String> listCar;
    public ParkinglotDto() {
    }

}
