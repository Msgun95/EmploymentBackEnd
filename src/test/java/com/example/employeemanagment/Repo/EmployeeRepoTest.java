package com.example.employeemanagment.Repo;

import com.example.employeemanagment.entitiy.Employee;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;


@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
class EmployeeRepoTest {


    @Autowired
    private EmployeeRepo employeeRepo;

    @Test
    public void setEmployeeRepo_SaveAll_return() {

        //arrange
        Employee employee = Employee.builder().fname("Msgun")
                .lname("Abr")
                .email("md@gmail.com").build();

        //act
        Employee saved = employeeRepo.save(employee);


        //Assert

        Assertions.assertThat(saved).isNotNull();
        Assertions.assertThat(saved.getId()).isGreaterThan(0);


    }

    @Test
    public void setEmployeeRepo_getAll_return() {
        Employee employee1 = Employee.builder().fname("Love")
                .lname("true").email("love@gmail.com").build();
        Employee employee2 = Employee.builder().fname("msgun")
                .lname("berhe").email("@gmail.com").build();

        employeeRepo.save(employee1);
        employeeRepo.save(employee2);
        List<Employee> employeeList = employeeRepo.findAll();

        Assertions.assertThat(employeeList).isNotNull();
        Assertions.assertThat(employeeList.size()).isEqualTo(2);


    }

    @Test
    public void setEmployeeRepo_getById_return() {
        Employee employee = Employee.builder().fname("haile")
                .lname("heni").email("@gmail.com").build();

        employeeRepo.save(employee);
        Employee employee2 = employeeRepo.findById(employee.getId()).get();
        Assertions.assertThat(employee2).isNotNull();
    }


@Test
public void setEmployeeRepo_getEmail_ReturnNotNull() {
    Employee employee = Employee.builder().fname("haile")
            .lname("heni").email("@gmail.com").build();

    employeeRepo.save(employee);
    Employee employee2 = employeeRepo.findByEmail(employee.getEmail()).get();
    Assertions.assertThat(employee2).isNotNull();


}
    @Test
    public void setEmployeeRepo_updateEmployee_return() {
        Employee employee = Employee.builder().fname("haile")
                .lname("heni").email("@gmail.com").build();

        employeeRepo.save(employee);
        Employee employeesave = employeeRepo.findById(employee.getId()).get();

        employeesave.setFname("msgun");
            employeesave.setLname("bbbb");
            employeesave.setEmail("@gmail.com");

            Employee employeeupdated = employeeRepo.save(employeesave);

        Assertions.assertThat(employeeupdated.getFname()).isNotNull();
        Assertions.assertThat(employeeupdated.getLname()).isNotNull();
        Assertions.assertThat(employeeupdated.getEmail()).isNotNull();
    }


//    @Test
//    public void setEmployeeRepo_deleteById_return() {
//        Employee employee = Employee.builder().fname("haile")
//                .lname("heni").email("@gmail.com").build();
//
//        employeeRepo.save(employee);
//        employeeRepo.deleteById(employee.getId());
//        Employee employee2 = employeeRepo.findById(employee.getId()).get();
//        Assertions.assertThat(employee2).isEmpty();
//    }


}