package com.multi.frontcontroller.controller;

import com.multi.frontcontroller.dao.BoardDAO;
import com.multi.frontcontroller.dto.BoardDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BoardListController implements Controller {
    @Override
    public String handle(HttpServletRequest request, HttpServletResponse response) {
        try {
            BoardDAO dao = new BoardDAO();
            List<BoardDTO> list = dao.findAll();
            request.setAttribute("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "list";
    }
}
