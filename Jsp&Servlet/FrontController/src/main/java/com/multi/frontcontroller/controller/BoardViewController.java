package com.multi.frontcontroller.controller;

import com.multi.frontcontroller.dao.BoardDAO;
import com.multi.frontcontroller.dto.BoardDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardViewController implements Controller {
    @Override
    public String handle(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            BoardDAO dao = new BoardDAO();
            BoardDTO dto = dao.findById(id);
            request.setAttribute("dto", dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "view";
    }
}
