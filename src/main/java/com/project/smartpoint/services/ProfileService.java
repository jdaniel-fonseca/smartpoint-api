package com.project.smartpoint.services;

import com.project.smartpoint.dto.ProfileDTO;
import com.project.smartpoint.entities.Profile;
import com.project.smartpoint.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    public List<ProfileDTO> findAll() {
        List<Profile> profiles = profileRepository.findAll();
        List<ProfileDTO> profileDTOS = profiles.stream()
                .map(ProfileDTO::new)
                .toList();

        return profileDTOS;
    }
}
