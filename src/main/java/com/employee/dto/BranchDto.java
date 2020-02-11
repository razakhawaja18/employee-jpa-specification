package com.employee.dto;

import lombok.Data;

@Data
public class BranchDto {

    private Long branchId;
    private String branchName;
    private Long branchPhoneNum;
    private String branchAddress;
    private String branchCountry;
    private CompanyDto companyDto;

}
