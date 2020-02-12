package com.employee.service;

import com.employee.dto.BranchDto;
import com.employee.dto.BranchResponseDto;
import com.employee.model.Branch;
import com.employee.model.Company;
import com.employee.repository.BranchRepository;
import com.employee.repository.CompanyRepository;
import com.employee.util.ConversionEntityDto;
import com.employee.util.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BranchServiceImpl implements BranchService {

    private BranchRepository branchRepository;
    private CompanyRepository companyRepository;

    public BranchServiceImpl(BranchRepository branchRepository, CompanyRepository companyRepository) {
        this.branchRepository = branchRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public BranchResponseDto saveOrUpdateBranch(BranchDto branchDto) {
        log.debug("In BranchServiceImpl -> saveOrUpdateBranch() Called | branchDto {}", branchDto);
        Branch branch = convertIntoBranch(branchDto);
        branch = branchRepository.save(branch);
        return new BranchResponseDto(convertIntoBranchDto(branch), ResponseMessage.SUCCESS_SAVE_UPDATE_MESSAGE);
    }

    private BranchDto convertIntoBranchDto(Branch branch) {
        BranchDto branchDto = ConversionEntityDto.getBranch(branch);
        Company company = companyRepository.findByBranchList(branch);
        branchDto.setCompanyDto(ConversionEntityDto.getCompanyDto(company));
        return branchDto;
    }

    private Branch convertIntoBranch(BranchDto branchDto) {
        Branch branch = ConversionEntityDto.getBranch(branchDto);
        Company company = new Company();
        company.setCompanyId(branchDto.getCompanyDto().getCompanyId());
        branch.setCompany(company);
        return branch;
    }
}
