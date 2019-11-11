package com.phodal.pepper.normal.file;

import java.io.File;

public class ATestFileClass {
    public void openFile(String fileName)
    {
        File f = new File(fileName);
        if(!f.exists())
        {
            throw new RuntimeException("File not found!");
        }
    }
}
