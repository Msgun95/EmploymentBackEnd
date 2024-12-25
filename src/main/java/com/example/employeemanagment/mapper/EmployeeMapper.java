package com.example.employeemanagment.mapper;

import com.example.employeemanagment.dto.EmployeeDto;
import com.example.employeemanagment.entitiy.Employee;

public class EmployeeMapper {

    public  static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFname(),
                employee.getLname(),
                employee.getEmail(),
                employee.getDepartment()

        );
    }
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(

                employeeDto.getId(),
                employeeDto.getFname(),
                employeeDto.getLname(),
                employeeDto.getEmail(),
                employeeDto.getDepartment()
        );

    }
}
