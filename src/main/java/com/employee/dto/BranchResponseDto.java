package com.employee.dto;

import lombok.Data;

@Data
public class BranchResponseDto {
    private String responseMessage;
    private BranchDto branchDto;
    public BranchResponseDto(){
    }
    public BranchResponseDto(BranchDto branchDto, String message){
        this.branchDto = branchDto;
        this.responseMessage = message;
    }
}
