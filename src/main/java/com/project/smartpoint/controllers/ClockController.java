package com.project.smartpoint.controllers;

import com.project.smartpoint.dto.request.ClockRequestDTO;
import com.project.smartpoint.dto.response.ClockResponseDTO;
import com.project.smartpoint.entities.Clock;
import com.project.smartpoint.services.ClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/clocks")
public class ClockController {

    private final ClockService clockService;
    public ClockController(ClockService clockService) {
        this.clockService = clockService;
    }

    @GetMapping("/allclocksoftheday/{id}")
    public ResponseEntity<List<ClockResponseDTO>> findAllOfTheDay(@PathVariable Long id) {
        List<ClockResponseDTO> clocks = clockService.findAllOfTheDay(id);
        return ResponseEntity.ok().body(clocks);
    }

    @GetMapping("/allclocksbyemployee/{id}")
    public ResponseEntity<Page<ClockResponseDTO>> findByEmployeeId(@PageableDefault(size = 31) Pageable pageable, @PathVariable Long id) {
        Page<ClockResponseDTO> clockResponseDTOS = clockService.findAllByEmployeeId(pageable, id);
        return ResponseEntity.ok().body(clockResponseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClockResponseDTO> findById(@PathVariable Long id) {
        ClockResponseDTO clock = clockService.findById(id).get();
        return ResponseEntity.ok().body(clock);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClockResponseDTO> update(@PathVariable Long id, @RequestBody ClockRequestDTO clockRequestDTO) {
        ClockResponseDTO clockResponseDTO = clockService.update(id, clockRequestDTO);
        return ResponseEntity.ok().body(clockResponseDTO);
    }

    @PostMapping
    public ResponseEntity<ClockResponseDTO> insert(@RequestBody ClockRequestDTO clockRequestDTO) {
        ClockResponseDTO clockResponseDto = clockService.insert(clockRequestDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/id")
                .buildAndExpand(clockResponseDto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(clockResponseDto);
    }

    @DeleteMapping("/{employeeId}/{id}")
    public ResponseEntity<Clock> deleteById(@PathVariable Long employeeId, @PathVariable Long id) {
        clockService.deleteById(employeeId, id);
        return ResponseEntity.noContent().build();
    }
}

