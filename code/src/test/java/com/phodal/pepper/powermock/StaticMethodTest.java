package com.phodal.pepper.powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.ArgumentMatchers.anyString;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore({"org.mockito.*", "org.powermock.*"})
@PrepareForTest(StaticMethod.class)
public class StaticMethodTest {
    @Test
    public void testMethodThatCallsStaticMethod() {
        PowerMockito.mockStatic(StaticMethod.class);
        Mockito.when(StaticMethod.firstStaticMethod("param")).thenReturn(true);
        Mockito.when(StaticMethod.secondStaticMethod()).thenReturn(123);

        new ClassCallStaticMethodObj().execute();

        PowerMockito.verifyStatic(StaticMethod.class, Mockito.times(2));
        StaticMethod.firstStaticMethod(anyString());
        StaticMethod.secondStaticMethod();
    }
}
