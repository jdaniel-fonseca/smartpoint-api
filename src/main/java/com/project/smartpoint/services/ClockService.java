package com.project.smartpoint.services;

import com.project.smartpoint.entities.Clock;
import com.project.smartpoint.entities.Employee;
import com.project.smartpoint.repositories.ClockRepository;
import com.project.smartpoint.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ClockService {

    @Autowired
    ClockRepository clockRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Clock> findAll() {
        List<Clock> clocks = clockRepository.findAll();
        return clocks;
    }

    public Optional<Clock> findById(Long id) {
        Optional<Clock> clock = clockRepository.findById(id);
        return clock;
    }

    public Set<Clock> findByEmployeeId(Long id) {
        return clockRepository.findByEmployeeId(id);
    }
}
