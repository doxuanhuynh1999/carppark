package com.example.carpark.controller;

import com.example.carpark.entity.Employee;
import com.example.carpark.exception.ExistedExcepttion;
import com.example.carpark.exception.NotFoundException;
import com.example.carpark.form.EmployeeForm;
import com.example.carpark.service.employee.ServiceEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class EmployeeController {
    @Autowired
    private ServiceEmployee serviceEmployee;
    @PostMapping(value = "/addEmployee")
    public ResponseEntity<Object> addEmployees(@RequestBody @Valid EmployeeForm employeeForm) throws ExistedExcepttion {
        return new ResponseEntity<>(serviceEmployee.addEmployee(employeeForm), HttpStatus.OK);
    }
    @GetMapping(value = "/getEmployees")
    public ResponseEntity<Object> getEmployeesList() {
        return new ResponseEntity<>(serviceEmployee.getEmployees(),HttpStatus.OK);
    }
    @PutMapping(value = "/updateEmployee/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable("id") Long id ,@RequestBody @Valid Employee employee) throws NotFoundException {
        serviceEmployee.updateEmployee(id, employee);
        return new ResponseEntity<>("update oke", HttpStatus.OK);
    }
    @DeleteMapping(value = "/deleteEmployee/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id") Long id) {
        serviceEmployee.deleteEmployee(id);
        return new ResponseEntity<>("delete oke", HttpStatus.OK);
    }
    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") Long id) throws NotFoundException {
        return new ResponseEntity<>(serviceEmployee.getById(id),HttpStatus.OK);
    }
}
