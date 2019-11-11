package com.phodal.pepper.normal.date.mockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class MyCalenderClassTest {
    private MyCalenderClass myClassTest;

    @Before
    public void setUp() {
        final Date date = Mockito.mock(Date.class);
        Mockito.when(date.getTime()).thenReturn(30L);

        final DateTime dt = Mockito.mock(DateTime.class);
        Mockito.when(dt.getDate()).thenReturn(date);

        myClassTest = new MyCalenderClass(dt);
    }

    @Test
    public void someTest() {
        final long doubleTime = myClassTest.getDoubleTime();
        assertEquals(60, doubleTime);
    }

}
