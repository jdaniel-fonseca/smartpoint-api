package com.project.smartpoint.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.smartpoint.entities.enums.ProfileType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "TB_PROFILE")
public class Profile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer profileType;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "TB_WORKER_PROFILE",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id"))
    private Set<Employee> employees = new HashSet<>();

    public Profile() {
    }

    public Profile(ProfileType profileType) {
        setProfileType(profileType);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProfileType getProfileType() {
        return ProfileType.valueOf(profileType);
    }

    public void setProfileType(ProfileType profileType) {
        if (profileType != null) {
            this.profileType = profileType.getCode();
        }
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Profile profile)) return false;
        return Objects.equals(id, profile.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
