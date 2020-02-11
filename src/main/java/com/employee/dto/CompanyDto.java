package com.employee.dto;

import lombok.Data;

@Data
public class CompanyDto {

    private Long companyId;
    private String companyName;
    private Long companyPhoneNum;
    private String companyAddress;
    private String companyCountry;

}
