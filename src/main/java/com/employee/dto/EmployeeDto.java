package com.employee.dto;

import com.employee.util.HairColor;
import java.util.Date;
import lombok.Data;

@Data
public class EmployeeDto {

    private Long employeeId;
    private String employeeName;
    private String employeeLastName;
    private String employeeAddress;
    private Long employeePhoneNum;
    private HairColor employeeHairColor;
    private Date createdAt;
    private Date updatedAt;
    private BranchDto branchDto;

}
