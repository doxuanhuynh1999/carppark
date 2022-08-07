package com.example.carpark.repository;

import com.example.carpark.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "update employee set account = ?1,department = ?2, employee_address = ?3, employee_birthday = ?4, employee_email = ?5, employee_name = ?6, employee_phone= ?7,password=?8,sex = ?9 where employee_id = ?10",nativeQuery = true)
    @Modifying
    void updateEmployee(String account, String department, String employeeAddress, LocalDate employeeBirthday, String employeeEmail, String employeeName, String employeePhone, String password, String sex, Long employeeId);
}
