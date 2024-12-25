package com.example.employeemanagment.entitiy;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "First_name")

    private String  fname;
    @Column(name = "Last_name")
    private String lname;

    @Column(name ="email", nullable = false, unique = true)
    private String email;
    private String department;





}
