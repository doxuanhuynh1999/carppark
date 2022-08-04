package com.example.carpark.controller;

import com.example.carpark.entity.Employee;
import com.example.carpark.sevice.ServiceEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class EmployeeController {
    @Autowired
    private ServiceEmployee serviceEmployee;
    @PostMapping(value = "/addEmployee")
    public ResponseEntity<Object> getEmployees(@RequestBody Employee employee) {
//        Employee employee = new Employee();
//        employee.setAccount("HuynhDX");
//        employee.setDepartment("IT");
//        employee.setEmployeeAddress("HaNOi");
//        employee.setEmployeeBirthday(new Date());
//        employee.setEmployeeEmail("huynhd@gmail.com");
//        employee.setEmpployeeName("huynh");
//        employee.setEmployeePhone("0965266856");
//        employee.setPassword("12345");
//        employee.setSex("nam");
        return new ResponseEntity<>(serviceEmployee.addEmployee(employee), HttpStatus.OK);
    }
    @GetMapping(value = "/getEmployees")
    public ResponseEntity<Object> getEmployeesList() {
        return new ResponseEntity<>(serviceEmployee.getEmployees(),HttpStatus.OK);
    }
}
