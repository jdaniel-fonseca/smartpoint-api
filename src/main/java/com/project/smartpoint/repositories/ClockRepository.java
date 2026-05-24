package com.project.smartpoint.repositories;

import com.project.smartpoint.entities.Clock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClockRepository extends JpaRepository<Clock, Long> {
}
