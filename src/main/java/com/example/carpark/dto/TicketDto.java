package com.example.carpark.dto;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalTime;

@Data
public class TicketDto {
    private Long ticketId;
    private LocalTime bookingTime;
    private String customerName;
    private String licensePlate;
    private Long tripId;
    public TicketDto() {
    }
}
