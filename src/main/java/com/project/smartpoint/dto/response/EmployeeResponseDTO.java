package com.project.smartpoint.dto.response;

import com.project.smartpoint.entities.Clock;
import com.project.smartpoint.entities.Employee;
import com.project.smartpoint.services.dtoconverter.ClockDtoConverter;

import java.util.ArrayList;
import java.util.List;

public class EmployeeResponseDTO {

    private Long id;
    private String name;
    private String email;
    private List<ClockResponseDTO> clocks = new ArrayList<>();

    public EmployeeResponseDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.email = employee.getEmail();

        for (Clock c : employee.getClocks()) {
            clocks.add(ClockDtoConverter.convertClockToResponseClockDto(c));
        }
    }
}
