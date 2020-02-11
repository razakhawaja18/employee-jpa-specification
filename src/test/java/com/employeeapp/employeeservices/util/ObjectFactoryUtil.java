package com.employeeapp.employeeservices.util;

import com.employee.dto.EmployeeDto;
import com.employee.model.Employee;
import com.employee.util.HairColor;

public class ObjectFactoryUtil {

    public static EmployeeDto employeeDtoMock() {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeName(ConstantUtil.EMPLOYEE_NAME);
        employeeDto.setEmployeeLastName(ConstantUtil.EMPLOYEE_LAST_NAME);
        employeeDto.setEmployeeAddress(ConstantUtil.EMPLOYEE_ADDRESS);
        employeeDto.setEmployeePhoneNum(ConstantUtil.EMPLOYEE_PHONE_NUM);
        employeeDto.setEmployeeHairColor(HairColor.BLACK);
        return employeeDto;
    }

    public static Employee employeeMock() {
        Employee employee = new Employee();
        employee.setEmployeeName(ConstantUtil.EMPLOYEE_NAME);
        employee.setEmployeeLastName(ConstantUtil.EMPLOYEE_LAST_NAME);
        employee.setEmployeeAddress(ConstantUtil.EMPLOYEE_ADDRESS);
        employee.setEmployeePhoneNum(ConstantUtil.EMPLOYEE_PHONE_NUM);
        employee.setEmployeeHairColor(HairColor.BLACK);
        return employee;
    }

}
