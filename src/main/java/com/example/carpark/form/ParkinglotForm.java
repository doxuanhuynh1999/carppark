package com.example.carpark.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ParkinglotForm {
    private Long parkId;
    @NotNull(message = "Should be not null")
    private Long parkArea;
    @NotNull(message = "Should be not null")
    private String parkName;
    @NotNull(message = "Should be not null")
    private String parkPlace;
    @NotNull(message = "Should be not null")
    private Long parkPrice;
    @NotNull(message = "Should be not null")
    private String parkStatus;
//    private List<String> listCar;
    public ParkinglotForm() {
    }

}
