package com.code.africa.employee.controller;

import com.code.africa.employee.model.Employee;
import com.code.africa.employee.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);

    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployee();

    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Map<String,Boolean>>deleteEmployee(@PathVariable Long id){
        boolean deleted = false;
        deleted = employeeService.deleteEmployee(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",deleted);
        return  ResponseEntity.ok(response);
    }


    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = null;
        employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);

    }

    @PutMapping("employee/{id}")
    public ResponseEntity<Employee>updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
        employee = employeeService.updateEmployee(id, employee);
        return  ResponseEntity.ok(employee);

    }

}
