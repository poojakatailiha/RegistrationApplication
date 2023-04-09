package com.mysql.registration.controller;

import com.mysql.registration.exception.ResourceNotFoundException;
import com.mysql.registration.model.Department;
import com.mysql.registration.repository.DepartmentRepository;
import com.mysql.registration.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    // Department GET Request :
    @GetMapping("/employee/{employeeId}/department")
    public Page<Department> getAllDepartmentByEmployeeId(@PathVariable (value = "employeeId") Long employeeId,
                                                Pageable pageable) {
        return departmentRepository.findByEmployeeId(employeeId, pageable);
    }

    // Department POST Request :
    @PostMapping("/employee/{employeeId}/department")
    public Department createDepartment(@PathVariable (value = "employeeId") Long employeeId,
                                    @Valid @RequestBody Department department) {
        return employeeRepository.findById(employeeId).map(employee -> {
            department.setEmployee(employee);
            return departmentRepository.save(department);
        }).orElseThrow(() -> new ResourceNotFoundException("EmployeeId " + employeeId + " not found"));
    }

    // Department PUT Request :
    @PutMapping("/employee/{employeeId}/department/{departmentId}")
    public Department updateDepartment(@PathVariable (value = "employeeId") Long employeeId,
                                 @PathVariable (value = "departmentId") Long departmentId,
                                 @Valid @RequestBody Department departmentRequest) {
        if(!employeeRepository.existsById(employeeId)) {
            throw new ResourceNotFoundException("EmployeeId " + employeeId + " not found");
        }

        return departmentRepository.findById(departmentId).map(department -> {
            department.setDepartmentname(departmentRequest.getDepartmentname());
            return departmentRepository.save(department);
        }).orElseThrow(() -> new ResourceNotFoundException("DepartmentId " + departmentId + "not found"));
    }

    // Department Delete Request :
    @DeleteMapping("/employee/{employeeId}/department/{departmentId}")
    public ResponseEntity<?> deleteDepartment(@PathVariable (value = "employeeId") Long employeeId,
                                           @PathVariable (value = "departmentId") Long departmentId) {
        return departmentRepository.findByIdAndEmployeeId(departmentId, employeeId).map(department -> {
            departmentRepository.delete(department);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Department not found with id " + departmentId + " and employeeId " + employeeId));
    }
}
