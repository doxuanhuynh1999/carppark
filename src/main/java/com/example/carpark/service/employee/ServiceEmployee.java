package com.example.carpark.service.employee;

import com.example.carpark.dto.EmployeeDTO;
import com.example.carpark.entity.Employee;
import com.example.carpark.form.EmployeeForm;

import java.util.List;
import java.util.Optional;

public interface ServiceEmployee {
    List<EmployeeDTO> getEmployees();
    Employee addEmployee(EmployeeForm employeeForm);
    Employee updateEmployee(Long employeeId,Employee employee);
    public boolean deleteEmployee(Long id);
    Optional<Employee> getById(Long employeeId);
}
