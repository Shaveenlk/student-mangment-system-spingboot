package com.example.springboot_backend.controller;

import com.example.springboot_backend.model.Employee;
import com.example.springboot_backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    //build create employee REST API
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    // build get all employees REST API
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeid){
        return new ResponseEntity<>(employeeService.getEmployeeById(employeeid),HttpStatus.OK);
    }

    // build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id),HttpStatus.OK);
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public String deleteEmployee(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);
        return "employ deleted";
    }
}
