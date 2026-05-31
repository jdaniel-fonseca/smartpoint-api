package com.project.smartpoint.services;
import com.project.smartpoint.dto.ProfileDTO;
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

    public List<ProfileDTO> findAll() {
        List<Profile> profiles = profileRepository.findAll();
        List<ProfileDTO> profileDTOS = profiles.stream()
                .map(ProfileDTO::new)
                .toList();

        return profileDTOS;
    }
    
    public Optional<ProfileDTO> findById(Long id) {
        return profileRepository.findById(id)
                .map(ProfileDTO::new);
    }
    
    public Profile insert (Profile profile) {
        return profileRepository.save(profile);
    }
    
    public void deleteById(Long id) {
        try {
            profileRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Profile update(Long id, Profile profile) {
        Profile pro = profileRepository.findById(id).get();
        updateData(profile, pro);
        return pro;
    }

    private void updateData(Profile pro, Profile profile) {
        pro.setProfileType(profile.getProfileType());
    }
}
