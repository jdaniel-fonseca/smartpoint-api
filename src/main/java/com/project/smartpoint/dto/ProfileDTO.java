package com.project.smartpoint.dto;

import com.project.smartpoint.entities.Profile;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProfileDTO {

    private Long id;
    private Integer profileType;

    public ProfileDTO(Profile profile) {
        this.id = profile.getId();
        this.profileType = profile.getProfileType().getCode();
    }
}
