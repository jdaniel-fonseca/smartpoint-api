package com.project.smartpoint.services;

import com.project.smartpoint.dto.EmployeeDTO;
import com.project.smartpoint.entities.Employee;
import com.project.smartpoint.repositories.EmployeeRepository;
import com.project.smartpoint.services.exceptions.DatabaseException;
import com.project.smartpoint.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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

    public Employee insert (Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteById (Long id) {
        try {
            employeeRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Employee update (Long id, Employee emp) {
        Employee employee = employeeRepository.findById(id).get();
        updateData(employee, emp);
        return employeeRepository.save(employee);
    }

    private void updateData (Employee employee, Employee emp) {
        employee.setEmail(emp.getEmail());
        employee.setName(emp.getName());
    }
}

