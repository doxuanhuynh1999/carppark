package com.example.carpark.dto;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;
@Data
public class BookingofficeDto {
    private Long officeId;
    private LocalDate endContractDeadline;
    private String officeName;
    private String officePhone;
    private String officePlace;
    private Long officePrice;
    private LocalDate startContractDeadline;
    private Long tripId;

    public BookingofficeDto() {
    }
}
