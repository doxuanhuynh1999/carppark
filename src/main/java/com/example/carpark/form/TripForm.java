package com.example.carpark.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
@Data
public class TripForm {
    private Long tripId;
    @NotNull(message = "Should be not null")
    private Integer bookedTicketNumber;
    @NotNull(message = "Should be not null")
    private String carType;
    @NotNull(message = "Should be not null")
    private LocalDate departureDate;
    private LocalTime departureTime;
    @NotNull(message = "Should be not null")
    private String destination;
    @NotNull(message = "Should be not null")
    private String driver;
    @NotNull(message = "Should be not null")
    private Integer maximumOnlineTicketNumber;
    public TripForm() {
    }
}
