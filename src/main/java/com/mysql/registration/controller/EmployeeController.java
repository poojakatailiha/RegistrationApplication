package com.mysql.registration.controller;

import com.mysql.registration.exception.ResourceNotFoundException;
import com.mysql.registration.model.Employee;
import com.mysql.registration.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    // Employee GET Request :
    @GetMapping("/employee")
    public Page<Employee> getAllEmployee(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    // Employee POST Request :
    @PostMapping("/employee")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // Employee PUT Request :
    @PutMapping("/employee/{employeeId}")
    public Employee updateEmployee(@PathVariable Long employeeId, @Valid @RequestBody Employee employeeRequest) {
        return employeeRepository.findById(employeeId).map(employee -> {
            employee.setEmployeename(employeeRequest.getEmployeename());
            employee.setEmployeedesignation(employeeRequest.getEmployeedesignation());
            employee.setEmpdata(employeeRequest.getEmpdata());
            return employeeRepository.save(employee);
        }).orElseThrow(() -> new ResourceNotFoundException("EmployeeId " + employeeId + " not found"));
    }

    // Employee DELETE Request :
    @DeleteMapping("/employee/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long employeeId) {
        return employeeRepository.findById(employeeId).map(employee -> {
            employeeRepository.delete(employee);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("EmployeeId " + employeeId + " not found"));
    }
}
