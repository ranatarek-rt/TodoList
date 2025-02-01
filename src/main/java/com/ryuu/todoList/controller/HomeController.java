package com.ryuu.todoList.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class HomeController {

    @RequestMapping(value="/")
    public void redirectHome(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
}