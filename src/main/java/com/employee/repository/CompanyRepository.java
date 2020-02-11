package com.employee.repository;

import com.employee.model.Branch;
import com.employee.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findByBranchList(Branch branch);
}
