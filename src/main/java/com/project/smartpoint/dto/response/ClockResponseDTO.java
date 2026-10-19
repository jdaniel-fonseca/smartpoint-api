package com.project.smartpoint.dto.response;

import com.project.smartpoint.entities.Clock;
import com.project.smartpoint.entities.Employee;
import com.project.smartpoint.entities.enums.ClockType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
public class ClockResponseDTO {

        private Long id;
        private Instant moment;
        private ClockType clockType;
        private Employee employee;

        public ClockResponseDTO(Clock clock) {
            this.id = clock.getId();
            this.moment = clock.getMoment();
            this.clockType = clock.getClockType();
            this.employee = clock.getEmployee();
        }
}
