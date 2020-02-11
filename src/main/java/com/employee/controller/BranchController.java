package com.employee.controller;

import com.employee.dto.BranchDto;
import com.employee.dto.BranchResponseDto;
import com.employee.service.BranchService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/branch")
@Slf4j
public class BranchController {

    private BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @PostMapping
    public BranchResponseDto saveOrUpdateBranch(@Valid @RequestBody BranchDto branchDto) {
        log.debug("In BranchController -> saveOrUpdateBranch() Called | branchDto {}", branchDto);
        return branchService
                .saveOrUpdateBranch(branchDto);
    }
}
