package com.project.smartpoint.dto.response;

import com.project.smartpoint.entities.Clock;
import com.project.smartpoint.entities.Employee;
import com.project.smartpoint.services.dtoconverter.ClockDtoConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class EmployeeResponseDTO {

    private Long id;
    private String name;
    private String email;

    public EmployeeResponseDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.email = employee.getEmail();
    }
}
