package com.example.carpark.dto;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalTime;
@Data
public class TripDto {
    private Long tripId;
    private Integer bookedTicketNumber;
    private String carType;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private String destination;
    private String driver;
    private Integer maximumOnlineTicketNumber;
    public TripDto() {
    }
}
