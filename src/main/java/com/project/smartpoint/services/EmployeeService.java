package com.project.smartpoint.services;

import com.project.smartpoint.dto.request.EmployeeRequestDTO;
import com.project.smartpoint.dto.response.EmployeeResponseDTO;
import com.project.smartpoint.entities.Employee;
import com.project.smartpoint.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    @Transactional
    public Page<EmployeeResponseDTO> findAll(Pageable pageable) {
        return employeeRepository
                .findAll(pageable)
                .map(EmployeeResponseDTO::new);
    };

    @Transactional
    public EmployeeResponseDTO findById(Long id) {
        return employeeRepository.findById(id)
                .map(EmployeeResponseDTO::new)
                .orElseThrow(() -> new RuntimeException("Id not found."));
    }

    @Transactional
    public void deleteById (Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id not found"));
            employeeRepository.delete(employee);
    }

    @Transactional
    public EmployeeResponseDTO update (Long id, EmployeeRequestDTO emp) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

       updateData(employee, emp);

        return new EmployeeResponseDTO(employee);
    }

    private void updateData (Employee employee, EmployeeRequestDTO emp) {
        employee.setEmail(emp.getEmail());
        employee.setName(emp.getName());
        employee.setPassword(emp.getPassword());
    }
}

