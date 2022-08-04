package com.example.carpark.dto;

import lombok.Data;

import java.util.Date;
@Data
public class EmployeeDTO {
    private Long employeeId;
    private String account;
    private String department;
    private String employeeAddress;
    private Date employeeBirthday;
    private String employeeEmail;
    private String empployeeName;
    private String employeePhone;
    private String sex;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long employeeId, String account, String department, String employeeAddress, Date employeeBirthday, String employeeEmail, String empployeeName, String employeePhone, String sex) {
        this.employeeId = employeeId;
        this.account = account;
        this.department = department;
        this.employeeAddress = employeeAddress;
        this.employeeBirthday = employeeBirthday;
        this.employeeEmail = employeeEmail;
        this.empployeeName = empployeeName;
        this.employeePhone = employeePhone;
        this.sex = sex;
    }
}
