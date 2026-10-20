package com.project.smartpoint.services.dtoconverter;

import com.project.smartpoint.dto.request.auth.RegisterDTO;
import com.project.smartpoint.dto.response.EmployeeResponseDTO;
import com.project.smartpoint.entities.Employee;
import com.project.smartpoint.entities.Profile;


public class EmployeeDtoConverter {

    public static Employee convertRegisterDtoIntoEmployee(RegisterDTO registerDTO) {
        Employee employee = new Employee();
        employee.setName(registerDTO.getName());
        employee.setEmail(registerDTO.getEmail());
        employee.setPassword(registerDTO.getPassword());
        employee.getProfiles().add(new Profile(registerDTO.getProfileType()));
        return employee;
    }

    public static EmployeeResponseDTO convertEmployeeToResponseEmployeeDto(Employee emp) {
        EmployeeResponseDTO empDto = new EmployeeResponseDTO(emp);
        return empDto;
    }
}
