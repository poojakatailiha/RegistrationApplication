package com.mysql.registration.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name = "employee")
public class Employee extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String employeename;

    @NotNull
    @Size(max = 250)
    private String employeedesignation;

    @NotNull
    @Lob
    private String empdata;

    //Getter and Setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public String getEmployeedesignation() {
        return employeedesignation;
    }

    public void setEmployeedesignation(String employeedesignation) {
        this.employeedesignation = employeedesignation;
    }

    public String getEmpdata() {
        return empdata;
    }

    public void setEmpdata(String empdata) {
        this.empdata = empdata;
    }
}
