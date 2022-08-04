package com.example.carpark.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "employee_id",length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(name = "account", length = 50)
    private String account;

    @Column(name = "department",length = 10)
    private String department;

    @Column(name = "employee_address",length = 50)
    private String employeeAddress;

    @Column(name = "employee_birthday")
    private Date employeeBirthday;

    @Column(name = "employee_email", length = 50)
    private String employeeEmail;

    @Column(name = "empployee_name",length = 50)
    private String empployeeName;

    @Column(name = "employee_phone",length = 10)
    private String employeePhone;

    @Column(name = "password",length = 20)
    private String password;

    @Column(name = "sex",length = 3)
    private String sex;

    public Employee() {
    }

    public Employee( String account, String department, String employeeAddress, Date employeeBirthday, String employeeEmail, String empployeeName, String employeePhone, String password, String sex) {
        this.account = account;
        this.department = department;
        this.employeeAddress = employeeAddress;
        this.employeeBirthday = employeeBirthday;
        this.employeeEmail = employeeEmail;
        this.empployeeName = empployeeName;
        this.employeePhone = employeePhone;
        this.password = password;
        this.sex = sex;
    }
}
