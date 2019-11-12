package com.phodal.pepper.powermock;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SpyMockEmployeeService.class)
public class SpyMockEmployeeServiceTest {
    @Test
    public void should_not_output_when_mock_class() {
        SpyMockEmployeeService employeeService = PowerMockito.mock(SpyMockEmployeeService.class);
        employeeService.foo();
    }

    @Test
    public void should_output_something_when_spy_object() {
        SpyMockEmployeeService employeeService1 = PowerMockito.spy(new SpyMockEmployeeService());
        employeeService1.foo();
    }

    @Test
    public void should_return_different_output_when_different_result() {
        SpyMockEmployeeService employeeService = PowerMockito.spy(new SpyMockEmployeeService());
        String arg = "hello";
        PowerMockito.doNothing().when(employeeService).foo(arg);
        employeeService.foo("hello");
    }

    @Test
    public void should_fail_when_exception() {
        try {
            SpyMockEmployeeService employeeService = PowerMockito.spy(new SpyMockEmployeeService());
            PowerMockito.doReturn(true).when(employeeService, "checkExist", "andy");
            Assert.assertTrue(employeeService.exist("andy"));
        } catch (Exception e) {
            Assert.fail();
        }
    }
}
