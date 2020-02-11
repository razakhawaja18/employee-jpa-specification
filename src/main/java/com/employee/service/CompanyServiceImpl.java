package com.employee.service;

import com.employee.dto.CompanyDto;
import com.employee.dto.CompanyResponseDto;
import com.employee.model.Company;
import com.employee.repository.CompanyRepository;
import com.employee.util.ResponseMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService{

    private CompanyRepository companyRepository;
    private ObjectMapper objectMapper;

    public CompanyServiceImpl(CompanyRepository companyRepository, ObjectMapper objectMapper){
        this.companyRepository = companyRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public CompanyResponseDto saveOrUpdateCompany(CompanyDto companyDto) {
        log.debug("In CompanyServiceImpl -> saveOrUpdateCompany() Called | companyDto {}", companyDto);
        return new CompanyResponseDto(
                objectMapper.convertValue(companyRepository.save(objectMapper.convertValue(companyDto,
                        Company.class)), CompanyDto.class), ResponseMessage.SUCCESS_SAVE_UPDATE_MESSAGE);
    }
}
