package com.phodal.pepper.normal.date.mockito;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;

import static org.junit.Assert.assertEquals;

@Ignore
public class MyDateClassTest {
    @Test
    public void someTest() {
        final Date date = Mockito.mock(Date.class);
        Mockito.when(date.getTime()).thenReturn(30L);

        final DateTime dt = Mockito.mock(DateTime.class);
        Mockito.when(dt.getDate()).thenReturn(date);

        MyDateClass myClassTest = new MyDateClass(dt);

        final long doubleTime = myClassTest.getDoubleTime();
        assertEquals(60, doubleTime);

        Mockito.verify(date, Mockito.times(1)).getTime();
        Mockito.verify(dt, Mockito.times(1)).getDate();
    }

}
