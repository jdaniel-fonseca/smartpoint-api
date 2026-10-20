package com.project.smartpoint.dto.response;

import com.project.smartpoint.entities.Profile;

public class ProfileResponseDTO {

    private Long id;
    private Integer profileType;

    public ProfileResponseDTO(Profile profile) {
        this.id = profile.getId();
        this.profileType = profile.getProfileType().getCode();
    }
}
