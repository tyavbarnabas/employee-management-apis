package com.code.africa.employee.repository;

import com.code.africa.employee.entity.EmployeeEntity;
import com.code.africa.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
