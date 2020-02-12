package com.employee.service;

import com.employee.dto.EmployeeResponseDto;
import com.employee.repository.EmployeeRepository;
import com.employee.util.ObjectFactoryUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTests {

    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private EmployeeServiceImpl employeeService;

    @Test
    public void testSaveOrUpdateEmployee() {
        when(employeeService.saveOrUpdateEmployee(ObjectFactoryUtil.employeeDtoMock())).thenReturn(ObjectFactoryUtil.employeeResponseDtoMock());
        EmployeeResponseDto employeeResponseDto = employeeService.saveOrUpdateEmployee(ObjectFactoryUtil.employeeDtoMock());
        assertNotNull(employeeResponseDto);
    }

    @Test
    public void testDeleteEmployee() {
        Long employeeId = 0L;
        employeeRepository.deleteById(anyLong());
        verify(employeeRepository, times(1)).deleteById(eq(employeeId));
    }

}