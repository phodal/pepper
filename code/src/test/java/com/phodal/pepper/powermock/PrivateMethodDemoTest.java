package com.phodal.pepper.powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({PrivateMethodDemo.class})
public class PrivateMethodDemoTest {
    @Test
    public void should_call_method_that_best_match_the_given_parameters_during_verification() throws Exception {
        final String stubbedValue = "another";
        final PrivateMethodDemo tested = mock(PrivateMethodDemo.class);

        when(tested.sayYear(anyString(), anyInt())).thenCallRealMethod();
        when(tested, "doSayYear", 12, "test").thenReturn(stubbedValue);

        assertThat(tested.sayYear("test", 12))
                .as("Private method is called")
                .isEqualTo(stubbedValue);

        verifyPrivate(tested).invoke(12, "test");
    }

}
