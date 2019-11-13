package com.phodal.pepper.refactor.staticclass;

import java.util.HashMap;
import java.util.Map;

public class RouterHandler {
    public static void gotoRoute(String routerName) {
        HashMap<String, String> routes = getStringStringHashMap();
        for (Map.Entry<String, String> entry : routes.entrySet()) {
            RouterNavigator.navigate(entry.getValue());
        }
    }

    private static HashMap<String, String> getStringStringHashMap() {
        HashMap<String, String> routes = new HashMap<>();
        routes.put("home", "/home");
        routes.put("about", "/pages/about");
        return routes;
    }
}
