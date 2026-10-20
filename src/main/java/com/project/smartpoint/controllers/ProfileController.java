package com.project.smartpoint.controllers;

import com.project.smartpoint.entities.Profile;
import com.project.smartpoint.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PutMapping("/{id}")
    public ResponseEntity<Profile> update (@PathVariable Long id, @RequestBody Profile profile) {
        profileService.update(id, profile);
        return ResponseEntity.ok().body(profile);
    }

    @PostMapping
    public ResponseEntity<Profile> insert(Profile profile) {
        profile = profileService.insert(profile);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(profile.getId())
                .toUri();

        return ResponseEntity.created(uri).body(profile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Profile> deleteById(@PathVariable Long id) {
        profileService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
