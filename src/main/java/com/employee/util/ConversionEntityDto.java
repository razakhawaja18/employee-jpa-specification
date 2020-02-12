package com.employee.util;

import com.employee.dto.BranchDto;
import com.employee.dto.CompanyDto;
import com.employee.dto.EmployeeDto;
import com.employee.model.Branch;
import com.employee.model.Company;
import com.employee.model.Employee;

public class ConversionEntityDto {

    private ConversionEntityDto() {

    }

    public static CompanyDto getCompanyDto(Company company) {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setCompanyId(company.getCompanyId());
        companyDto.setCompanyName(company.getCompanyName());
        companyDto.setCompanyPhoneNum(company.getCompanyPhoneNum());
        companyDto.setCompanyAddress(company.getCompanyAddress());
        companyDto.setCompanyCountry(company.getCompanyCountry());
        return companyDto;
    }

    public static Company getCompany(CompanyDto companyDto) {
        Company company = new Company();
        company.setCompanyId(companyDto.getCompanyId());
        company.setCompanyName(companyDto.getCompanyName());
        company.setCompanyPhoneNum(companyDto.getCompanyPhoneNum());
        company.setCompanyAddress(companyDto.getCompanyAddress());
        company.setCompanyCountry(companyDto.getCompanyCountry());
        return company;
    }

    public static BranchDto getBranch(Branch branch) {
        BranchDto branchDto = new BranchDto();
        branchDto.setBranchId(branch.getBranchId());
        branchDto.setBranchName(branch.getBranchName());
        branchDto.setBranchPhoneNum(branch.getBranchPhoneNum());
        branchDto.setBranchCountry(branch.getBranchCountry());
        branchDto.setBranchAddress(branch.getBranchAddress());
        return branchDto;
    }

    public static Branch getBranch(BranchDto branchDto) {
        Branch branch = new Branch();
        branch.setBranchId(branchDto.getBranchId());
        branch.setBranchName(branchDto.getBranchName());
        branch.setBranchPhoneNum(branchDto.getBranchPhoneNum());
        branch.setBranchCountry(branchDto.getBranchCountry());
        branch.setBranchAddress(branchDto.getBranchAddress());
        return branch;
    }

    public static EmployeeDto getEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeId(employee.getEmployeeId());
        employeeDto.setEmployeeName(employee.getEmployeeName());
        employeeDto.setEmployeeLastName(employee.getEmployeeName());
        employeeDto.setEmployeeAddress(employee.getEmployeeAddress());
        employeeDto.setEmployeePhoneNum(employee.getEmployeePhoneNum());
        employeeDto.setEmployeeHairColor(employee.getEmployeeHairColor());
        return employeeDto;
    }

    public static Employee getEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setEmployeeName(employeeDto.getEmployeeName());
        employee.setEmployeeLastName(employeeDto.getEmployeeName());
        employee.setEmployeeAddress(employeeDto.getEmployeeAddress());
        employee.setEmployeePhoneNum(employeeDto.getEmployeePhoneNum());
        employee.setEmployeeHairColor(employeeDto.getEmployeeHairColor());
        return employee;
    }
}
