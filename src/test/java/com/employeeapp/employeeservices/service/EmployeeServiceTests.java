package com.employeeapp.employeeservices.service;

import com.employee.dto.EmployeeResponseDto;
import com.employee.model.Employee;
import com.employee.repository.BranchRepository;
import com.employee.repository.CompanyRepository;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import com.employee.service.EmployeeServiceImpl;
import com.employeeapp.employeeservices.util.ConstantUtil;
import com.employeeapp.employeeservices.util.ObjectFactoryUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTests {

    @Mock
    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;
    @Mock
    private CompanyRepository companyRepository;
    @Mock
    private BranchRepository branchRepository;
    @Mock
    private ObjectMapper objectMapper;

    @Before
    public void setUp() {
        employeeService = new EmployeeServiceImpl(employeeRepository, companyRepository, branchRepository, new ObjectMapper());
    }

    @Test
    public void testSaveOrUpdateEmployee() {
        when(employeeRepository.save(any(Employee.class)))
                .thenReturn(ObjectFactoryUtil.employeeMock());
        EmployeeResponseDto employeeMessageDto = employeeService
                .saveOrUpdateEmployee(ObjectFactoryUtil.employeeDtoMock());
        assertEquals(ConstantUtil.SUCCESS_MESSAGE, employeeMessageDto.getResponseMessage());
        assertEquals(ConstantUtil.EMPLOYEE_NAME, employeeMessageDto.getEmployeeDto().getEmployeeName());
    }

    @Test
    public void testDeleteEmployee() {
        Long employeeId = 0L;
        employeeRepository.deleteById(anyLong());
        verify(employeeRepository, times(1)).deleteById(eq(employeeId));
    }

}