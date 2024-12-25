package com.example.employeemanagment.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {

    private Long id;

//    @Column(name = "First_name")

    private String  fname;

    private String lname;

    private String email;
    private String department;
}
