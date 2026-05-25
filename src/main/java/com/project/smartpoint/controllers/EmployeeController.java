package com.project.smartpoint.controllers;

import com.project.smartpoint.dto.EmployeeDTO;
import com.project.smartpoint.entities.Employee;
import com.project.smartpoint.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findAll() {
        List<Employee> employees = employeeService.findAll();

        List<EmployeeDTO> dtoList = employees.stream()
                .map(EmployeeDTO::new)
                .toList();

        return ResponseEntity.ok().body(dtoList);
    }
}
