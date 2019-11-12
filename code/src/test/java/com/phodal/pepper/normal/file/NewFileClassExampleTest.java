package com.phodal.pepper.normal.file;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;

import static org.mockito.ArgumentMatchers.anyString;

@RunWith(PowerMockRunner.class)
@PrepareForTest(NewFileExample.class)
public class NewFileClassExampleTest {
    @Test
    public void testFile() throws Exception {
        File mockedFile = Mockito.mock(File.class);
        Mockito.when(mockedFile.exists()).thenReturn(true);

        PowerMockito.whenNew(File.class).withParameterTypes(String.class).withArguments(anyString()).thenReturn(mockedFile);

        NewFileExample classToTest = new NewFileExample();
        classToTest.openFile("testfile.txt");

        PowerMockito.verifyNew(File.class).withArguments("testfile.txt");
        Mockito.verify(mockedFile).exists();
    }
}
