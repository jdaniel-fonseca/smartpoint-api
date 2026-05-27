package com.project.smartpoint.dto;

import com.project.smartpoint.entities.Employee;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDTO {

   private Long id;
   private String name;
   private String email;

   public EmployeeDTO(Employee employee) {
       this.id = employee.getId();
       this.name = employee.getName();
       this.email = employee.getEmail();
   }
}
