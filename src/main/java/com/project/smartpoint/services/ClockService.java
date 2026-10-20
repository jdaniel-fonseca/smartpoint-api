package com.project.smartpoint.services;

import com.project.smartpoint.dto.response.ClockResponseDTO;
import com.project.smartpoint.entities.Clock;
import com.project.smartpoint.entities.Employee;
import com.project.smartpoint.repositories.ClockRepository;
import com.project.smartpoint.repositories.EmployeeRepository;
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
import java.util.Set;
import java.util.stream.Collectors;

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
        LocalDate hoje = LocalDate.now(zone);

        Instant inicioDia = hoje.atStartOfDay(zone).toInstant();
        Instant fimDia = hoje.atTime(LocalTime.MAX).atZone(zone).toInstant();

        return clockRepository.findPointsByEmployeeAndDate(id, inicioDia, fimDia)
                .stream()
                .map(ClockResponseDTO::new)
                .toList();
    }

    @Transactional
    public Optional<ClockResponseDTO> findById(Long id) {
        return clockRepository.findById(id)
                .map(ClockResponseDTO::new);
    }

    public Clock insert(Clock clock) {
        return clockRepository.save(clock);
    }

    public void deleteById(Long employeeId, Long id) {
        Employee employee = employeeRepository.getReferenceById(employeeId);
        for (Clock c : employee.getClocks()) {
            if (c.getId() == id) {
                employee.getClocks().remove(c);
            }
        }
    }
}
