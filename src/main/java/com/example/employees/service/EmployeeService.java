package com.example.employees.service;

import com.example.employees.model.Employee;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {
    List<Employee> listAll();


    Employee findById(String id);


    Employee create(String name, String email, String type, LocalDate employmentDate);


    Employee update(String id, String name, String email, String type, LocalDate employmentDate);


    void delete(String id);
}
