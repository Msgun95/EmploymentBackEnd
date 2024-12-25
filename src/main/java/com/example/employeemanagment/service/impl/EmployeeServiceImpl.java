package com.example.employeemanagment.service.impl;

import com.example.employeemanagment.Repo.EmployeeRepo;
import com.example.employeemanagment.dto.EmployeeDto;
import com.example.employeemanagment.entitiy.Employee;
import com.example.employeemanagment.exception.ResourceNotFoundException;
import com.example.employeemanagment.mapper.EmployeeMapper;
import com.example.employeemanagment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl  implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;


    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
       Employee saveemployee= employeeRepo.save(employee);;
        return EmployeeMapper.mapToEmployeeDto(saveemployee);
    }

    @Override
    public EmployeeDto getByIdEmployee(Long id) {
     Employee employee=   employeeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException(" Employee with "+id+" not found"));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employee = employeeRepo.findAll();
        return employee.stream().map((employee1) ->EmployeeMapper.mapToEmployeeDto(employee1))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee employeeToUpdate = employeeRepo.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Nos Such "+id +" Employee"));
       employeeToUpdate.setFname(employeeDto.getFname());
       employeeToUpdate.setLname(employeeDto.getLname());
       employeeToUpdate.setEmail(employeeDto.getEmail());

       Employee employeeObj= employeeRepo.save(employeeToUpdate);

       return EmployeeMapper.mapToEmployeeDto(employeeObj);



    }

    @Override
    public void deletEmployee(Long id) {
        Employee employeeDto = employeeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("No such Id "+id));
         employeeRepo.deleteById(id);
    }

    @Override
    public List<EmployeeDto> getEmployeeByDepartment(String dep) {
        Optional<List<Employee>> employeeOneDepartment = employeeRepo.findAllByDepartment(dep);
        return employeeOneDepartment.orElseGet(List::of).stream().map((employees -> EmployeeMapper.mapToEmployeeDto(employees))).collect(Collectors.toList());
    }


}
