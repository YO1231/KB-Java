package com.multi.frontcontroller.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
    private HashMap<String, Controller> map = new HashMap<>();

    @Override
    public void init() throws ServletException {
        map.put("/list.do", new BoardListController());
        map.put("/writeForm.do", new BoardWriteFormController());
        map.put("/write.do", new BoardWriteController());
        map.put("/view.do", new BoardViewController());
        map.put("/editForm.do", new BoardEditFormController());
        map.put("/edit.do", new BoardEditController());
        map.put("/delete.do", new BoardDeleteController());
        map.put("/search.do", new BoardSearchController());
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String context = req.getContextPath();
        String command = uri.substring(context.length());

        Controller controller = map.get(command);
        if (controller != null) {
            String view = controller.handle(req, resp);
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/" + view + ".jsp");
            rd.forward(req,resp);
        }
    }
}
