package com.example.carpark.form;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
public class EmployeeForm {
    private Long employeeId;
    @NotNull(message = "Should be not null")
    private String account;
    @NotNull(message = "Should be not null")
    private String department;
    @NotNull(message = "Should be not null")
    private String employeeAddress;
    @NotNull(message = "Should be not null")
    private LocalDate employeeBirthday;
    @NotNull(message = "Should be not null")
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9\\-_]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,3}$",message = "Email fail")
    private String employeeEmail;
    @NotNull(message = "Should be not null")
    @Pattern(regexp = "^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}",message = "Name fail")
    private String empployeeName;
    @NotNull(message = "Should be not null")
    @Pattern(regexp = "^((09|03|012|08|06)+([0-9]{8}))$",message = "Phone fail")
    private String employeePhone;
    @NotNull(message = "Should not be null")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{4,6}$" , message = "Password must match with criteria")
    private String password;
    @NotNull(message = "Should be not null")
    private String sex;

    public EmployeeForm() {
    }

}
