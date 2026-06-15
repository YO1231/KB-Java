package com.multi.frontcontroller.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardWriteFormController implements Controller {
    @Override
    public String handle(HttpServletRequest request, HttpServletResponse response) {
        return "writeForm";
    }
}
