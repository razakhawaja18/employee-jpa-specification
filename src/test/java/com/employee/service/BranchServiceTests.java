package com.employee.service;

import com.employee.dto.BranchResponseDto;
import com.employee.util.ObjectFactoryUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BranchServiceTests {

    @Mock
    private BranchServiceImpl branchService;

    @Test
    public void testSaveOrUpdateBranch() {
        when(branchService.saveOrUpdateBranch(ObjectFactoryUtil.branchDtoMock())).thenReturn(ObjectFactoryUtil.branchResponseDtoMock());
        BranchResponseDto branchResponseDto = branchService.saveOrUpdateBranch(ObjectFactoryUtil.branchDtoMock());
        assertNotNull(branchResponseDto);
    }

}
