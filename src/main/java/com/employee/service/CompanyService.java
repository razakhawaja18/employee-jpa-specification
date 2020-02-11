package com.employee.service;

import com.employee.dto.CompanyDto;
import com.employee.dto.CompanyResponseDto;

public interface CompanyService {
    CompanyResponseDto saveOrUpdateCompany(CompanyDto companyDto);
}
