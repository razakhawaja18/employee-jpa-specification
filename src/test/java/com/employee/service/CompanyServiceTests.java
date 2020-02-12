package com.employee.service;

import com.employee.dto.CompanyResponseDto;
import com.employee.util.ObjectFactoryUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CompanyServiceTests {

    @Mock
    private CompanyServiceImpl companyService;

    @Test
    public void testSaveOrUpdateCompany() {
        when(companyService.saveOrUpdateCompany(ObjectFactoryUtil.companyDtoMock())).thenReturn(ObjectFactoryUtil.companyResponseDtoMock());
        CompanyResponseDto companyResponseDto = companyService.saveOrUpdateCompany(ObjectFactoryUtil.companyDtoMock());
        assertNotNull(companyResponseDto);
    }

}
