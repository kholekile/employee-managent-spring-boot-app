package com.tangent.employeemanagementservice.repository;

import com.tangent.employeemanagementservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String>{
}
