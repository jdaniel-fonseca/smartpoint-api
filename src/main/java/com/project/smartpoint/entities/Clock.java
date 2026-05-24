package com.project.smartpoint.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.smartpoint.entities.enums.ClockType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "TB_CLOCK")
public class Clock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;
    private ClockType clockType;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Clock() {
    }

    public Clock(Long id, Instant moment, ClockType clockType, Employee employee) {
        this.id = id;
        this.moment = moment;
        this.clockType = clockType;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public ClockType getClockType() {
        return clockType;
    }

    public void setClockType(ClockType clockType) {
        this.clockType = clockType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Clock clock)) return false;
        return Objects.equals(id, clock.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
