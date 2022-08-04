package com.example.carpark.sevice;

import com.example.carpark.dto.EmployeeDTO;
import com.example.carpark.entity.Employee;
import com.example.carpark.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceEmployeeIpm implements ServiceEmployee{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> getEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(this :: converEmploeeToDto)
                .collect(Collectors.toList());
    }

    private EmployeeDTO converEmploeeToDto(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeId(employee.getEmployeeId());
        employeeDTO.setAccount(employee.getAccount());
        employeeDTO.setDepartment(employee.getDepartment());
        employeeDTO.setEmployeeAddress(employee.getEmployeeAddress());
        employeeDTO.setEmployeeBirthday(employee.getEmployeeBirthday());
        employeeDTO.setEmployeeEmail(employee.getEmployeeEmail());
        employeeDTO.setEmpployeeName(employee.getEmpployeeName());
        employeeDTO.setEmployeePhone(employee.getEmployeePhone());
        employeeDTO.setSex(employee.getSex());
        return employeeDTO;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        return false;
    }
}
