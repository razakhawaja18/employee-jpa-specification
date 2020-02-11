package com.employee.service;

import com.employee.dto.EmployeeDto;
import com.employee.dto.EmployeeRequestDto;
import com.employee.dto.EmployeeResponseDto;
import com.employee.dto.PageDto;

public interface EmployeeService {
     PageDto<EmployeeResponseDto> getAllEmployeeWithSpecification(EmployeeRequestDto employeeRequestDto);
     EmployeeResponseDto saveOrUpdateEmployee(EmployeeDto employeeDto);
}
