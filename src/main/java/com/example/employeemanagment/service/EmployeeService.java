package com.example.employeemanagment.service;

import com.example.employeemanagment.dto.EmployeeDto;
import com.example.employeemanagment.entitiy.Employee;

import java.util.List;

public interface EmployeeService {

 public EmployeeDto createEmployee(EmployeeDto employeeDto);
    public EmployeeDto getByIdEmployee(Long id);

    public List<EmployeeDto> getAllEmployee();

    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto);

    public  void deletEmployee(Long id);

    public List<EmployeeDto> getEmployeeByDepartment(String dep);
}
