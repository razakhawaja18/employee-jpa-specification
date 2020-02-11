package com.employee.service;

import com.employee.dto.BranchDto;
import com.employee.dto.BranchResponseDto;
import com.employee.dto.CompanyDto;
import com.employee.model.Branch;
import com.employee.model.Company;
import com.employee.repository.BranchRepository;
import com.employee.repository.CompanyRepository;
import com.employee.util.ResponseMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BranchServiceImpl implements BranchService {

    private BranchRepository branchRepository;
    private ObjectMapper objectMapper;
    private CompanyRepository companyRepository;

    public BranchServiceImpl(BranchRepository branchRepository, CompanyRepository companyRepository, ObjectMapper objectMapper) {
        this.branchRepository = branchRepository;
        this.companyRepository = companyRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public BranchResponseDto saveOrUpdateBranch(BranchDto branchDto) {
        log.debug("In BranchServiceImpl -> saveOrUpdateBranch() Called | branchDto {}", branchDto);
        Branch branch = branchRepository.save(convertIntoBranch(branchDto));
        return new BranchResponseDto(convertIntoBranchDto(branch),
                ResponseMessage.SUCCESS_SAVE_UPDATE_MESSAGE);
    }

    private BranchDto convertIntoBranchDto(Branch branch) {
        BranchDto branchDto = objectMapper.convertValue(branch, BranchDto.class);
        Company company = companyRepository.findByBranchList(branch);
        branchDto.setCompanyDto(objectMapper.convertValue(company, CompanyDto.class));
        return branchDto;
    }

    private Branch convertIntoBranch(BranchDto branchDto) {
        Branch branch = objectMapper.convertValue(branchDto, Branch.class);
        Company company = new Company();
        company.setCompanyId(branchDto.getCompanyDto().getCompanyId());
        branch.setCompany(company);
        return branch;
    }
}
