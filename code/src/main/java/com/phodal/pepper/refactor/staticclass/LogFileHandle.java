package com.phodal.pepper.refactor.staticclass;

import java.util.HashMap;
import java.util.Map;

public class LogFileHandle {
    public static void gotoRoute(String routerName) {
        HashMap<String, String> files = getFilesMap();
        for (Map.Entry<String, String> entry : files.entrySet()) {
            FileHandler.verify(entry.getValue());
        }
    }

    private static HashMap<String, String> getFilesMap() {
        HashMap<String, String> filesMap = new HashMap<>();
        filesMap.put("home", "/home");
        filesMap.put("about", "/pages/about");
        return filesMap;
    }
}
