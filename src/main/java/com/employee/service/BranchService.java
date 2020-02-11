package com.employee.service;


import com.employee.dto.BranchDto;
import com.employee.dto.BranchResponseDto;

public interface BranchService {
    BranchResponseDto saveOrUpdateBranch(BranchDto branchDto);
}
