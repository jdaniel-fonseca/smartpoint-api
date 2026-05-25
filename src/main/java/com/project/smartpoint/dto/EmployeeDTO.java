package com.project.smartpoint.dto;

import com.project.smartpoint.entities.Employee;
import lombok.Data;

@Data
public class EmployeeDTO {

   private Long id;
   private String name;
   private String email;

   public EmployeeDTO(Employee employee) {
       this.id = employee.getId();
       this.email = employee.getEmail();
       this.name = employee.getName();
   }
}
