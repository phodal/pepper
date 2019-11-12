package com.phodal.pepper.powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(PowerMockRunner.class)
@PrepareForTest({MockCalenderInstance.class})
public class MockCalenderInstanceTest {
    @Test
    public void should_return_mock_date_when_calendar_instance() {
        Calendar endOfMarch = Calendar.getInstance();
        endOfMarch.set(1991, Calendar.MARCH, 27);
        PowerMockito.mockStatic(Calendar.class);
        Mockito.when(Calendar.getInstance()).thenReturn(endOfMarch);

        MockCalenderInstance mockCalenderInstance = new MockCalenderInstance();
        Date date = mockCalenderInstance.getDate();

        assertThat(date).isEqualTo(endOfMarch.getTime());
    }
}
