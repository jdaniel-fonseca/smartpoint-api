
package com.project.smartpoint.controllers;

import com.project.smartpoint.dto.request.EmployeeRequestDTO;
import com.project.smartpoint.dto.response.EmployeeResponseDTO;
import com.project.smartpoint.services.EmployeeService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<Page<EmployeeResponseDTO>> findAll(
           @ParameterObject @PageableDefault(size = 31) Pageable pageable) {

        Page<EmployeeResponseDTO> employees =
                employeeService.findAll(pageable);

        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> findById(
            @PathVariable Long id) {

        EmployeeResponseDTO employee =
                employeeService.findById(id);

        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> update(
            @PathVariable Long id,
            @RequestBody EmployeeRequestDTO request) {

        EmployeeResponseDTO employee =
                employeeService.update(id, request);

        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable Long id) {

        employeeService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
