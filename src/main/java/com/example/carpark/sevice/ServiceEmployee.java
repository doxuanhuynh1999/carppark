package com.example.carpark.sevice;

import com.example.carpark.dto.EmployeeDTO;
import com.example.carpark.entity.Employee;

import javax.persistence.Embeddable;
import java.util.List;

public interface ServiceEmployee {
    List<EmployeeDTO> getEmployees();
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    public boolean deleteEmployee(Long id);
}
