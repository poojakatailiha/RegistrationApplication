package com.mysql.registration.repository;

import com.mysql.registration.model.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
    List<Department> findByEmployeeId(Long employeeId);
    Optional<Department> findByIdAndEmployeeId(Long id, Long employeeId);
}
