package com.project.smartpoint.controllers;

import com.project.smartpoint.entities.Clock;
import com.project.smartpoint.services.ClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Clock> insert(@RequestBody Clock clock) {
        clock = clockService.insert(clock);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clock.getId())
                .toUri();

        return ResponseEntity.created(uri).body(clock);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Clock> deleteById(@PathVariable Long employeeId, @PathVariable Long id) {
        clockService.deleteById(employeeId, id);
        return ResponseEntity.noContent().build();
    }
}
