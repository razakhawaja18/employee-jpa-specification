package com.employee.controller;

import com.employee.dto.EmployeeDto;
import com.employee.dto.EmployeeRequestDto;
import com.employee.dto.EmployeeResponseDto;
import com.employee.dto.PageDto;
import com.employee.service.EmployeeService;
import com.employee.util.ObjectValidator;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employee")
@Slf4j
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    public PageDto<EmployeeResponseDto> getAllEmployeeWithSpecification(@RequestBody EmployeeRequestDto employeeRequestDto) {
        log.debug("In EmployeeController -> getAllEmployeeWithSpecification() Called {} | employeeRequestDto", employeeRequestDto);
        return employeeService
                .getAllEmployeeWithSpecification(employeeRequestDto);
    }

    @PostMapping
    public EmployeeResponseDto saveOrUpdateEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        log.debug("In saveOrUpdateEmployee -> saveOrUpdateEmployee() Called | employeeDto {}", employeeDto);
        ObjectValidator.validateEmployeeDto(employeeDto);
        return employeeService
                .saveOrUpdateEmployee(employeeDto);
    }
}

