package com.project.smartpoint.dto.request;

import com.project.smartpoint.entities.Employee;
import com.project.smartpoint.entities.enums.ClockType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClockRequestDTO {

    private Instant moment;
    private Employee employee;

}
