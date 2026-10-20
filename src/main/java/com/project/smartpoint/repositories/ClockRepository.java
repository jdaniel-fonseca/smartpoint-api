package com.project.smartpoint.repositories;

import com.project.smartpoint.entities.Clock;
import jakarta.persistence.JoinColumn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ClockRepository extends JpaRepository<Clock, Long> {

    @Query("""
       SELECT c 
       FROM Clock c 
       WHERE c.employee.id = :employeeId
       """)
    Page<Clock> findAllByEmployeeId(@Param("employeeId") Long employeeId, Pageable pageable);

    @Query("""
       SELECT c 
       FROM Clock c 
       WHERE c.employee.id = :employeeId 
         AND c.moment >= :inicioDia 
         AND c.moment <= :fimDia
       ORDER BY c.moment ASC
       """)
    List<Clock> findPointsByEmployeeAndDate(
            @Param("employeeId") Long employeeId,
            @Param("inicioDia") Instant inicioDia,
            @Param("fimDia") Instant fimDia
    );
}
