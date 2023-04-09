package com.mysql.registration.repository;

import com.mysql.registration.model.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
    Page<Department> findByEmployeeId(Long employeeId, Pageable pageable);
    Optional<Department> findByIdAndEmployeeId(Long id, Long employeeId);
}
