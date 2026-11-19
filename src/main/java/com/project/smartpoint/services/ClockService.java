package com.project.smartpoint.services;

import com.project.smartpoint.dto.request.ClockRequestDTO;
import com.project.smartpoint.dto.response.ClockResponseDTO;
import com.project.smartpoint.entities.Clock;
import com.project.smartpoint.entities.Employee;
import com.project.smartpoint.repositories.ClockRepository;
import com.project.smartpoint.repositories.EmployeeRepository;
import com.project.smartpoint.services.dtoconverter.ClockDtoConverter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class ClockService {

    @Autowired
    ClockRepository clockRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Transactional
    public Page<ClockResponseDTO> findAllByEmployeeId(Pageable pageable, Long id) {
        return clockRepository
                .findAllByEmployeeId(id, pageable)
                .map(ClockResponseDTO::new);
    }

    @Transactional
    public List<ClockResponseDTO> findAllOfTheDay(Long id) {

        ZoneId zone = ZoneId.of("America/Sao_Paulo");
        LocalDate today = LocalDate.now(zone);

        Instant startOfTheDay = today.atStartOfDay(zone).toInstant();
        Instant endOfTheDay = today.atTime(LocalTime.MAX).atZone(zone).toInstant();

        return clockRepository.findClocksByEmployeeAndDate(id, startOfTheDay, endOfTheDay)
                .stream()
                .map(ClockResponseDTO::new)
                .toList();
    }

    @Transactional
    public Optional<ClockResponseDTO> findById(Long id) {
        return clockRepository.findById(id)
                .map(ClockResponseDTO::new);
    }

    @Transactional
    public ClockResponseDTO update(Long id, ClockRequestDTO clockRequestDTO) {
        Clock clock = clockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found."));

        updateData(clockRequestDTO, clock);

        return new ClockResponseDTO(clock);
    }

    @Transactional
    public ClockResponseDTO insert(ClockRequestDTO clockRequestDTO) {
        Employee employee = employeeRepository.getReferenceById(clockRequestDTO.getEmployeeId());
        Clock clock = clockRepository.save(ClockDtoConverter.convertClockRequestDtoIntoClock(clockRequestDTO, employee));
        return new ClockResponseDTO(clock);
    }

    @Transactional
    public void deleteById(Long employeeId, Long id) {
        Employee employee = employeeRepository.getReferenceById(employeeId);
        for (Clock c : employee.getClocks()) {
            if (c.getId() == id) {
                employee.getClocks().remove(c);
            }
        }
    }

    private void updateData(ClockRequestDTO clockRequestDTO, Clock clock) {
        clock.setMoment(clockRequestDTO.getMoment());
    }
}
