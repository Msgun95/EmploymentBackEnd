//package com.example.employeemanagment.controller;
//
//import com.example.employeemanagment.dto.EmployeeDto;
//import com.example.employeemanagment.entitiy.Employee;
//import com.example.employeemanagment.service.EmployeeService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.hamcrest.CoreMatchers;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentMatchers;
//import org.mockito.BDDMockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//
//import java.util.Arrays;
//
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(controllers = EmployeeController.class)
//@AutoConfigureMockMvc(addFilters = false)
//@ExtendWith(MockitoExtension.class)
//class EmployeeControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private EmployeeService employeeService;
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    private Employee employee;
//    private EmployeeDto employeeDto;
//    @BeforeEach
//    public void init(){
//        Employee employee = Employee.builder().fname("haile").lname("heni").email("@gmail.com").build();
//        EmployeeDto employeeDto = EmployeeDto.builder().fname("haile").lname("heni").email("@gmail.com").build();
//    }
//
//
//    @Test
//    void createEmployeeTest() throws Exception {
//
//        // Arrange
//        BDDMockito.given(employeeService.createEmployee(ArgumentMatchers.any()))
//                .willAnswer(invocation -> invocation.getArgument(0));
//
//        // Act
//        ResultActions resultActions = mockMvc.perform(post("/api/employees")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsBytes(employeeDto)));
//
//        // Assert
//        resultActions.andExpect(status().isCreated())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.fname", CoreMatchers.is(employeeDto.getFname())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.lname", CoreMatchers.is(employeeDto.getLname())))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.email", CoreMatchers.is(employeeDto.getEmail())))
//                .andDo(print());
//
//
//    }
//
//    @Test
//    void findByIdEmployee() {
//    }
//
//    @Test
//    void getAllEmployee() throws Exception{
//        EmployeeDto employeeDto1 = EmployeeDto.builder()
//                .pageSize(10)
//                .last(true)
//                .pageNo(1)
//                .content(Arrays.asList()) // Corrected Array.asList to Arrays.asList
//                .build();
//        when(employeeService.getAllEmployee(1, 10)).thenReturn(employeeDto);
//        ResultActions response = mockMvc.perform(get("/api/employees")
//                        .contentType(MediaType.APPLICATION_JSON)
//                .param("pageNo", "1")
//                .param("pageSize", "10"));
//
//        response.andExpect(MockMvcResultMatchers.status())
//                . andExpect(MockMvcResultMatchers.jsonPath("$.content.size()", CoreMatchers.is(employeeDto.getContemnt.size())))
//                .andDo(print());
//
//    }
//
//    @Test
//    void updateEmployee() {
//    }
//
//    @Test
//    void deletEmployee() {
//    }
//}