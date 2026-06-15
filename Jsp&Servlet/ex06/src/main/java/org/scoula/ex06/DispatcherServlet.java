package org.scoula.ex06;

import org.scoula.ex06.command.Command;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.Map;

public class DispatcherServlet extends HttpServlet {
    Map<String, Command> getMap;
    Map<String, Command> postMap;

    String prefix = "/WEB-INF//views/";
    String suffix = ".jsp";


    @Override
    public void init() {
        getMap = new HashMap<>();
        postMap = new HashMap<>();
        createMap(getMap, postMap);
    }

    protected void createMap(Map<String, Command> getMap, Map<String, Command> postMap) {

    }
}
