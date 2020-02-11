package com.employee.controller;

import com.employee.dto.CompanyDto;
import com.employee.dto.CompanyResponseDto;
import com.employee.service.CompanyService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/company")
@Slf4j
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public CompanyResponseDto saveOrUpdateCompany(@Valid @RequestBody CompanyDto companyDto) {
        log.debug("In CompanyController -> saveOrUpdateCompany() Called | companyDto {}", companyDto);
        return companyService
                .saveOrUpdateCompany(companyDto);
    }
}
