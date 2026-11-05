package com.project.smartpoint.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.smartpoint.entities.Clock;
import com.project.smartpoint.entities.Profile;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestDTO {

    private String name;
    private String email;
    private String password;
    private Set<Clock> clocks = new HashSet<>();
    private Set<Profile> profiles = new HashSet<>();

}
