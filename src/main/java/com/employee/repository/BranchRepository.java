package com.employee.repository;

import com.employee.model.Branch;
import com.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
    Branch findByEmployeeList (Employee employee);
}
