package com.example.carpark.service.employee;

import com.example.carpark.dto.EmployeeDTO;
import com.example.carpark.entity.Employee;
import com.example.carpark.exception.ExistedExcepttion;
import com.example.carpark.exception.NotFoundException;
import com.example.carpark.form.EmployeeForm;
import com.example.carpark.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceEmployeeIpm implements ServiceEmployee {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> getEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(data -> {
                    EmployeeDTO employeeDTO = new EmployeeDTO();
                    BeanUtils.copyProperties(data, employeeDTO);
                    return employeeDTO;
                }).collect(Collectors.toList());
    }
    @Override
    public Employee addEmployee(EmployeeForm employeeForm) {
         Employee employee = new Employee();
         BeanUtils.copyProperties(employeeForm, employee);
        return employeeRepository.save(employee);
    }
    @Override
    @Transactional
    public Employee updateEmployee(Long employeeId,Employee employee) {
        Employee employee1 = employeeRepository.findById(employeeId).stream().findFirst().orElse(null);
        if (employee1 != null) {
            employeeRepository.updateEmployee(employee.getAccount(), employee.getDepartment(),employee.getEmployeeAddress(),employee.getEmployeeBirthday(),employee.getEmployeeEmail(),employee.getEmpployeeName(),employee.getEmployeePhone(),employee.getPassword(),employee.getSex(),employeeId);
            return employee;
        }else {
            throw new NotFoundException("Not found employee with id " + employeeId);
        }
    }
    @Override
    public boolean deleteEmployee(Long id) {
        Employee employee1 = employeeRepository.findById(id).stream().findFirst().orElse(null);
        if (employee1 != null) {
            employeeRepository.deleteById(id);
            return true;
        }else {
            throw new NotFoundException("Not found employee with id " + id);
        }
    }

    @Override
    public Optional<Employee> getById(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }
}
