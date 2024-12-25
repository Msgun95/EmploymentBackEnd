package com.example.employeemanagment.service.impl;

import com.example.employeemanagment.Repo.EmployeeRepo;
import com.example.employeemanagment.dto.EmployeeDto;
import com.example.employeemanagment.entitiy.Employee;


import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {
    @Mock
    private EmployeeRepo employeeRepo;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

   @Test
   public void createEmployeeTest(){
       Employee employee = Employee.builder().fname("haile")
               .lname("heni").email("@gmail.com").build();

       EmployeeDto employeeDto = EmployeeDto.builder().fname("Ms")
               .lname("love").email("@gmail.com").build();
       when(employeeRepo.save(Mockito.any(Employee.class))).thenReturn(employee);

       EmployeeDto savedEmployee =employeeService.createEmployee(employeeDto);

       Assertions.assertThat(savedEmployee).isNotNull();

   }

//    @Test
//    public void getAllEmployeeTest() {
//
//        Page<Employee> employeePage = Mockito.mock(Page.class);
//
//        when(employeeRepo.findAll(Mockito.any(Pageable.class))).thenReturn(employeePage);
//
//        Employee saveemployee =employeeService.getAllEmployee(1, 10);
//
//      Assertions.assertThat(saveemployee).isNotNull();
//
//    }



    @Test
    void getByIdEmployee() {

        Employee employee = Employee.builder().fname("haile")
                .lname("heni").email("@gmail.com").build();

        when(employeeRepo.findById(1L)).thenReturn(Optional.ofNullable(employee));

        EmployeeDto savedEmployee =employeeService.getByIdEmployee(1L);

        Assertions.assertThat(savedEmployee).isNotNull();


        Assertions.assertThat(savedEmployee.getFname()).isEqualTo("haile");
        Assertions.assertThat(savedEmployee.getLname()).isEqualTo("heni");
        Assertions.assertThat(savedEmployee.getEmail()).isEqualTo("@gmail.com");


    }
@Test
public void employeeByDepartmentTest(){
    Employee employee = Employee.builder().fname("haile")
            .lname("heni").email("@gmail.com").department("hr").build();

    when(employeeRepo.findAllByDepartment("hr")).thenReturn(Optional.of(Arrays.asList(employee)));

//    List<Employee> employees =employeeService.getEmployeeByDepartment("hr");
    List<EmployeeDto> employees =employeeService.getEmployeeByDepartment("hr");


    Assertions.assertThat(employees).isNotNull();
    Assertions.assertThat(employees.size()).isEqualTo(1);
    Assertions.assertThat(employees.get(0).getFname()).isEqualTo("haile");
    Assertions.assertThat(employees.get(0).getDepartment()).isEqualTo("hr");


}

    @Test
    void updateEmployee() {

        Employee employee = Employee.builder().fname("haile")
                .lname("heni").email("@gmail.com").build();

        EmployeeDto employeeDto = EmployeeDto.builder().fname("Ms")
                .lname("love").email("@gmail.com").build();

        when(employeeRepo.findById(1L)).thenReturn(Optional.ofNullable(employee));
        when(employeeRepo.save(Mockito.any(Employee.class))).thenReturn(employee);

        EmployeeDto savedEmployee =employeeService.updateEmployee(1L, employeeDto );

        Assertions.assertThat(savedEmployee).isNotNull();

    }

    @Test
    void deleteEmployee() {
        Employee employee = Employee.builder().fname("haile")
                .lname("heni").email("@gmail.com").build();

        when(employeeRepo.findById(1L)).thenReturn(Optional.ofNullable(employee));



        assertAll(()-> employeeService.deletEmployee(1l));
    }
}