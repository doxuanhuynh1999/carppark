package com.example.carpark.form;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@Data
public class CarForm {
    @NotEmpty(message = "should not be empty")
    private String licensePlate;
    private String carColor;
    private String carType;
    private String company;
    private Long parkingId;
    public CarForm() {
    }
}
