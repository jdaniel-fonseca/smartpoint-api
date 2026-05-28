package com.project.smartpoint.dto;
import com.project.smartpoint.entities.Clock;
import com.project.smartpoint.entities.Employee;
import com.project.smartpoint.entities.enums.ClockType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
public class ClockDTO {
    private Long id;
    private Instant moment;
    private ClockType clockType;
    private Employee employee;

    public ClockDTO(Clock clock) {
        this.id = clock.getId();
        this.moment = clock.getMoment();
        this.clockType = clock.getClockType();
        this.employee = clock.getEmployee();
    }
}
