package com.employee.util;

import com.employee.dto.BranchDto;
import com.employee.dto.BranchResponseDto;
import com.employee.dto.CompanyDto;
import com.employee.dto.CompanyResponseDto;
import com.employee.dto.EmployeeDto;
import com.employee.dto.EmployeeResponseDto;

public class ObjectFactoryUtil {

    public static EmployeeDto employeeDtoMock() {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeName(ConstantUtil.EMPLOYEE_NAME);
        employeeDto.setEmployeeLastName(ConstantUtil.EMPLOYEE_LAST_NAME);
        employeeDto.setEmployeeAddress(ConstantUtil.EMPLOYEE_ADDRESS);
        employeeDto.setEmployeePhoneNum(ConstantUtil.EMPLOYEE_PHONE_NUM);
        employeeDto.setEmployeeHairColor(HairColor.BLACK);
        BranchDto branchDto = new BranchDto();
        branchDto.setBranchId(ConstantUtil.ID);
        employeeDto.setBranchDto(branchDto);
        return employeeDto;
    }

    public static EmployeeResponseDto employeeResponseDtoMock() {
        EmployeeDto employeeDto = employeeDtoMock();
        employeeDto.setBranchDto(branchDtoMock());
        return new EmployeeResponseDto(employeeDto, ConstantUtil.SUCCESS_MESSAGE);
    }

    public static CompanyDto companyDtoMock() {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setCompanyId(ConstantUtil.ID);
        return companyDto;
    }

    public static CompanyResponseDto companyResponseDtoMock() {
        return new CompanyResponseDto(companyDtoMock(), ConstantUtil.SUCCESS_MESSAGE);
    }

    public static BranchDto branchDtoMock() {
        BranchDto branchDto = new BranchDto();
        branchDto.setCompanyDto(companyDtoMock());
        branchDto.setBranchId(ConstantUtil.ID);
        return branchDto;
    }

    public static BranchResponseDto branchResponseDtoMock() {
        return new BranchResponseDto(branchDtoMock(), ConstantUtil.SUCCESS_MESSAGE);
    }
}
