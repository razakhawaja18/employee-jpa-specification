package com.employee.service;

import com.employee.dto.BranchDto;
import com.employee.dto.CompanyDto;
import com.employee.dto.EmployeeDto;
import com.employee.dto.EmployeeRequestDto;
import com.employee.dto.EmployeeResponseDto;
import com.employee.dto.PageDto;
import com.employee.model.Branch;
import com.employee.model.Company;
import com.employee.model.Employee;
import com.employee.repository.BranchRepository;
import com.employee.repository.CompanyRepository;
import com.employee.repository.EmployeeRepository;
import com.employee.service.specifications.EmployeeSpecificationFactory;
import com.employee.util.ConversionEntityDto;
import com.employee.util.PaginatedRequest;
import com.employee.util.ResponseMessage;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private CompanyRepository companyRepository;
    private BranchRepository branchRepository;
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, CompanyRepository companyRepository,
                               BranchRepository branchRepository) {
        this.employeeRepository = employeeRepository;
        this.branchRepository = branchRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    @SuppressWarnings("unchecked")
    public PageDto<EmployeeResponseDto> getAllEmployeeWithSpecification(EmployeeRequestDto employeeRequestDto) {
        log.debug("In employeeServiceImpl -> getAllEmployeeWithSpecification() Called | employeeDto {}", employeeRequestDto);
        Specification employeeSpecification = EmployeeSpecificationFactory.searchEmployeeWithSpecification(employeeRequestDto);
        PaginatedRequest paginatedRequest = getPaginatedRequest(employeeRequestDto);
        Optional<Page<Employee>> employeeList = Optional.of(employeeRepository.
                findAll(employeeSpecification, paginatedRequest));
        return new PageDto(employeeList
                .filter(pd -> !pd.isEmpty())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, ResponseMessage.EMPLOYEE_NOT_FOUND))
                .stream().map(this::convertToEmployeeDto).collect(Collectors.toList()),
                employeeList.get().getTotalElements(), employeeRequestDto.firstResult, employeeList.get().getNumberOfElements(),
                employeeRequestDto.sortColumn, employeeRequestDto.sortDirection);
    }

    @Override
    public EmployeeResponseDto saveOrUpdateEmployee(EmployeeDto employeeDto) {
        log.debug("In employeeServiceImpl -> saveOrUpdateEmployee() Called | employeeDto {}", employeeDto);
        Employee employee = convertIntoEmployee(employeeDto);
        employee = employeeRepository.save(employee);
        return new EmployeeResponseDto(convertToEmployeeDto(employee), ResponseMessage.SUCCESS_SAVE_UPDATE_MESSAGE);
    }

    private PaginatedRequest getPaginatedRequest(EmployeeRequestDto employeeRequestDto) {
        return new PaginatedRequest(employeeRequestDto.firstResult, employeeRequestDto.maxResults,
                new Sort(employeeRequestDto.sortDirection, employeeRequestDto.sortColumn));
    }

    private Employee convertIntoEmployee(EmployeeDto employeeDto) {
        Employee employee = ConversionEntityDto.getEmployee(employeeDto);
        Branch branch = new Branch();
        branch.setBranchId(employeeDto.getBranchDto().getBranchId());
        employee.setBranch(branch);
        return employee;
    }

    private EmployeeDto convertToEmployeeDto(Employee employee) {
        Branch branch = branchRepository.findByEmployeeList(employee);
        Company company = companyRepository.findByBranchList(branch);
        EmployeeDto employeeDto = ConversionEntityDto.getEmployeeDto(employee);
        BranchDto branchDto = ConversionEntityDto.getBranch(branch);
        CompanyDto companyDto = ConversionEntityDto.getCompanyDto(company);
        branchDto.setCompanyDto(companyDto);
        employeeDto.setBranchDto(branchDto);
        return employeeDto;
    }
}