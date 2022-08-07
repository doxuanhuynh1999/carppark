package com.example.carpark.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Data
public class TicketForm {
    private Long ticketId;
    private LocalTime bookingTime;
    @NotNull(message = "Should be not null")
    private String customerName;
    @NotNull(message = "Should be not null")
    private String licensePlate;
    @NotNull(message = "Should be not null")
    private Long tripId;
    public TicketForm() {
    }
}
