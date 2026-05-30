package com.project.smartpoint.services;

import com.project.smartpoint.dto.EmployeeDTO;
import com.project.smartpoint.entities.Employee;
import com.project.smartpoint.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<EmployeeDTO> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOS = employees.stream()
                .map(EmployeeDTO::new)
                .toList();
        return employeeDTOS;
    }

    public void insert (Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteById (Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee update (Long id, Employee emp) {
        Employee employee = employeeRepository.findById(id).get();
        updateData(employee, emp);
        return employeeRepository.save(employee);
    }

    public void updateData (Employee employee, Employee emp) {
        employee.setEmail(emp.getEmail());
        employee.setName(emp.getName());
    }
}

