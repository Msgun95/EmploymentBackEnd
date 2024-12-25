package com.example.employeemanagment.controller;

import com.example.employeemanagment.dto.EmployeeDto;
import com.example.employeemanagment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedemployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedemployee, HttpStatus.CREATED);


    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> findByIdEmployee(@PathVariable("id") Long id){
        EmployeeDto employeeDto = employeeService.getByIdEmployee(id);
        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>>  getAllEmployee(){
        List<EmployeeDto> employeeDtos = employeeService.getAllEmployee();

        return ResponseEntity.ok(employeeDtos);


    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable ("id") Long id, @RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDto1 = employeeService.updateEmployee(id, employeeDto);
        return ResponseEntity.ok(employeeDto1);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletEmployee(@PathVariable("id") Long id){
        employeeService.deletEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");


    }



}
