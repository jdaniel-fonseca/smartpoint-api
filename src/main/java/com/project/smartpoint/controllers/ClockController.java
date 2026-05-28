package com.project.smartpoint.controllers;

import com.project.smartpoint.dto.ClockDTO;
import com.project.smartpoint.entities.Clock;
import com.project.smartpoint.services.ClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/clocks")
public class ClockController {

    @Autowired
    ClockService clockService;

    @GetMapping
    public ResponseEntity<List<ClockDTO>> findAll() {
        List<ClockDTO> clocks = clockService.findAll();
        return ResponseEntity.ok().body(clocks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClockDTO> findById(@PathVariable Long id) {
        ClockDTO clock = clockService.findById(id).get();
        return ResponseEntity.ok().body(clock);
    }

    @GetMapping("/employeeclocks/{employeeId}")
    public ResponseEntity<Set<ClockDTO>> findByEmployeeId(@PathVariable Long employeeId) {
        Set<ClockDTO> clocks = clockService.findByEmployeeId(employeeId);
        return ResponseEntity.ok().body(clocks);
    }
}
