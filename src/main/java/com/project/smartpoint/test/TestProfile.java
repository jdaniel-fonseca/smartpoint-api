package com.project.smartpoint.test;

import com.project.smartpoint.entities.Clock;
import com.project.smartpoint.entities.Employee;
import com.project.smartpoint.entities.enums.ClockType;
import com.project.smartpoint.repositories.ClockRepository;
import com.project.smartpoint.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestProfile implements CommandLineRunner {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ClockRepository clockRepository;

    @Override
    public void run(String... args) throws Exception {
        Employee e1 = new Employee(null, "João Silva", "joão@gmail.com", "jo@o2390");
        Employee e2 = new Employee(null, "Ana Maria", "ana@gmail.com", "@n@23640");
        Employee e3 = new Employee(null, "Renato", "renato@gmail.com", "renato290890");
        employeeRepository.saveAll(Arrays.asList(e1, e2, e3));

        Clock c1 = new Clock(null, Instant.now(), ClockType.ENTRANCE, e1);
        Clock c2 = new Clock(null, Instant.now(), ClockType.LUNCH_EXIT, e1);
        Clock c3 = new Clock(null, Instant.now(), ClockType.LUNCH_BACK, e1);
        Clock c4 = new Clock(null, Instant.now(), ClockType.EXIT, e1);
        clockRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
    }
}
