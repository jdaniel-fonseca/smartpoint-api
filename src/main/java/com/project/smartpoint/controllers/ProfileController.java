package com.project.smartpoint.controllers;

import com.project.smartpoint.dto.ProfileDTO;
import com.project.smartpoint.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping
    ResponseEntity<List<ProfileDTO>> findAll() {
        List<ProfileDTO> profileDTOS = profileService.findAll();
        return ResponseEntity.ok().body(profileDTOS);
    }
}
