package com.example.employees.service.impl;

import com.example.employees.model.Employee;
import com.example.employees.repository.EmployeeRepository;
import com.example.employees.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> listAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(String id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee create(String name, String email, String type, LocalDate employmentDate) {
        String id = UUID.randomUUID().toString();
        Employee employee = Employee.builder()
                .id(id)
                .name(name)
                .email(email)
                .type(type)
                .employmentDate(employmentDate)
                .build();

        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(String id, String name, String email, String type, LocalDate employmentDate) {
        Employee employee = this.findById(id);

        employee.setName(name);
        employee.setEmail(email);
        employee.setType(type);
        employee.setEmploymentDate(employmentDate);

        return employeeRepository.save(employee);
    }

    @Override
    public void delete(String id) {
        Employee employee = this.findById(id);
        employeeRepository.delete(employee);
    }
}