package com.employee.service;

import com.employee.dto.CompanyDto;
import com.employee.dto.CompanyResponseDto;
import com.employee.model.Company;
import com.employee.repository.CompanyRepository;
import com.employee.util.ConversionEntityDto;
import com.employee.util.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public CompanyResponseDto saveOrUpdateCompany(CompanyDto companyDto) {
        log.debug("In CompanyServiceImpl -> saveOrUpdateCompany() Called | companyDto {}", companyDto);
        Company company = ConversionEntityDto.getCompany(companyDto);
        company = companyRepository.save(company);
        return new CompanyResponseDto(ConversionEntityDto.getCompanyDto(company), ResponseMessage.SUCCESS_SAVE_UPDATE_MESSAGE);
    }
}
