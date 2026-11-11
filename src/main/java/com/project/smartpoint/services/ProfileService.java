package com.project.smartpoint.services;
import com.project.smartpoint.dto.response.ProfileResponseDTO;
import com.project.smartpoint.entities.Profile;
import com.project.smartpoint.repositories.ProfileRepository;
import com.project.smartpoint.services.exceptions.DatabaseException;
import com.project.smartpoint.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    public List<ProfileResponseDTO> findAll() {
        List<Profile> profiles = profileRepository.findAll();
        List<ProfileResponseDTO> profileDTOS = profiles.stream()
                .map(ProfileResponseDTO::new)
                .toList();

        return profileDTOS;
    }
    
    public ProfileResponseDTO findById(Long id) {
        return profileRepository.findById(id)
                .map(ProfileResponseDTO::new)
                .orElseThrow(() -> new RuntimeException("Profile not found."));
    }
    
    public Profile insert (Profile profile) {
        return profileRepository.save(profile);
    }
    
    public void deleteById(Long id) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found."));
        profileRepository.delete(profile);
    }

    public Profile update(Long id, Profile profile) {
        Profile prof = profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found."));
        updateData(profile, prof);
        return prof;
    }

    private void updateData(Profile pro, Profile profile) {
        pro.setProfileType(profile.getProfileType());
    }
}
