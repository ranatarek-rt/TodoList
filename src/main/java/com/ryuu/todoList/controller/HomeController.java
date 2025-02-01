package com.ryuu.todoList.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    @GetMapping("/")
    public String redirectHome() {
        return "redirect:/swagger-ui/index.html";
    }

}