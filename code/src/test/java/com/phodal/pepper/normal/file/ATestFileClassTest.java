package com.phodal.pepper.normal.file;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ATestFileClass.class)
public class ATestFileClassTest {
    @Test
    public void testFile() throws Exception
    {
        File mockedFile = Mockito.mock(File.class);
        Mockito.when(mockedFile.exists()).thenReturn(true);

        PowerMockito.whenNew(File.class).withParameterTypes(String.class).withArguments(Matchers.anyString()).thenReturn(mockedFile);

        ATestFileClass classToTest = new ATestFileClass();
        classToTest.openFile("testfile.txt");

        PowerMockito.verifyNew(File.class).withArguments("testfile.txt");
        Mockito.verify(mockedFile).exists();
    }
}
