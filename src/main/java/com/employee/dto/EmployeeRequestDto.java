package com.employee.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EmployeeRequestDto extends PageDto {

    private EmployeeDto employeeDto;
    private BranchDto branchDto;
    private CompanyDto companyDto;

}

