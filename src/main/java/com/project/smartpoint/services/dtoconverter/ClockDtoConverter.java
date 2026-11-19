package com.project.smartpoint.services.dtoconverter;

import com.project.smartpoint.dto.request.ClockRequestDTO;
import com.project.smartpoint.dto.response.ClockResponseDTO;
import com.project.smartpoint.entities.Clock;
import com.project.smartpoint.entities.Employee;
import com.project.smartpoint.entities.enums.ClockType;

import java.time.Instant;

public class ClockDtoConverter {

    public static Clock convertClockRequestDtoIntoClock(ClockRequestDTO clockRequestDTO, Employee employee) {
        Clock clock = new Clock();
        if (employee.getClocks().size() == 0) {
            clock.setClockType(ClockType.ENTRANCE);
        }
        else if (employee.getClocks().size() == 1) {
            clock.setClockType(ClockType.LUNCH_EXIT);
        }
        else if (employee.getClocks().size() == 2) {
            clock.setClockType(ClockType.LUNCH_BACK);
        }
        else if (employee.getClocks().size() == 3) {
            clock.setClockType(ClockType.EXIT);
        }
        else {
            throw new RuntimeException();
        }
        clock.setEmployee(employee);
        clock.setMoment(Instant.now());
        return clock;
    }

    public static ClockResponseDTO convertClockToResponseClockDto(Clock clock) {
        ClockResponseDTO clockResponseDTO = new ClockResponseDTO(clock);
        return clockResponseDTO;
    }

}
