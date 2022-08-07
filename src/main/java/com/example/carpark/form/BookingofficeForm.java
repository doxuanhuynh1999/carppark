package com.example.carpark.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
@Data
public class BookingofficeForm {
    private Long officeId;
    private LocalDate endContractDeadline;
    @Pattern(regexp = "^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}",message = "Name fail")
    private String officeName;
    @NotNull(message = "Should be not null")
    @Pattern(regexp = "^((09|03|012|08|06)+([0-9]{8}))$",message = "Phone fail")
    private String officePhone;
    @NotNull(message = "Should be not null")
    private String officePlace;
    private Long officePrice;
    private LocalDate startContractDeadline;
    @NotNull(message = "Should be not null")
    private Long tripId;

    public BookingofficeForm() {
    }
}
