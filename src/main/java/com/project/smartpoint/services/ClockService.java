package com.project.smartpoint.services;

import com.project.smartpoint.dto.ClockDTO;
import com.project.smartpoint.entities.Clock;
import com.project.smartpoint.repositories.ClockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClockService {

    @Autowired
    ClockRepository clockRepository;

    public List<ClockDTO> findAll() {
        List<Clock> clocks = clockRepository.findAll();

        List<ClockDTO> clockDTOS = clocks.stream()
                .map(ClockDTO::new)
                .toList();

        return clockDTOS;
    }

    public Optional<ClockDTO> findById(Long id) {
        return clockRepository.findById(id)
                .map(ClockDTO::new);
    }

    public Set<ClockDTO> findByEmployeeId(Long id) {
        return clockRepository.findByEmployeeId(id).stream()
                .map(ClockDTO::new)
                .collect(Collectors.toSet());
    }
}
