package com.employee.dto;

import lombok.Data;

@Data
public class CompanyResponseDto {

    private String responseMessage;
    private CompanyDto companyDto;

    public CompanyResponseDto() {
    }

    public CompanyResponseDto(CompanyDto companyDto, String message) {
        this.companyDto = companyDto;
        this.responseMessage = message;
    }
}
