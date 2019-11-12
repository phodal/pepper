package com.phodal.pepper.powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(PowerMockRunner.class)
@PrepareForTest({FinalClass.class})
public class FinalClassTest {
    @Test
    public void getValue() throws Exception {
        FinalClass fc = new FinalClass("foobar");
        FinalClass fcMock = PowerMockito.mock(FinalClass.class);

        PowerMockito.when(fcMock.getValue()).thenReturn("foobarTwo");

        assertThat(fc.getValue()).isEqualTo("foobar");
        assertThat(fcMock.getValue()).isEqualTo("foobarTwo");

        Mockito.verify(fcMock).getValue();
    }
}
