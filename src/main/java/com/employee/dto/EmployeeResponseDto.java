package com.employee.dto;

import lombok.Data;

@Data
public class EmployeeResponseDto {

    private String responseMessage;
    private EmployeeDto employeeDto;
    public EmployeeResponseDto(){
    }
    public EmployeeResponseDto(EmployeeDto employeeDto, String message){
        this.employeeDto = employeeDto;
        this.responseMessage = message;
    }
}
