package com.project.smartpoint.repositories;

import com.project.smartpoint.entities.Clock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

@Repository
public interface ClockRepository extends JpaRepository<Clock, Long> {

    Set<Clock> findByEmployeeId(Long employeeId);

}
