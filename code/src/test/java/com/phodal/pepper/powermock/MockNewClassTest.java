package com.phodal.pepper.powermock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.awt.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(PowerMockRunner.class)
@PrepareForTest(MockNewClass.class)
public class MockNewClassTest {

    private MockNewClass powerMockDemo;

    @Before
    public void setUp() {
        powerMockDemo = new MockNewClass();
    }

    @Test
    public void testMockNew() throws Exception {
        Point mockPoint = mock(Point.class);

        PowerMockito.whenNew(Point.class).withAnyArguments().thenReturn(mockPoint);

        Point actualMockPoint = powerMockDemo.publicMethod();
        assertThat(actualMockPoint, is(mockPoint));
    }
}
