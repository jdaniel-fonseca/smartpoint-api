package com.project.smartpoint.dto.request.auth;

import com.project.smartpoint.entities.enums.ProfileType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {

    private ProfileType profileType;
    private String name;
    private String email;
    private String password;

}
