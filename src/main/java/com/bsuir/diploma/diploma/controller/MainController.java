package com.bsuir.diploma.diploma.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/main")
@AllArgsConstructor
public class MainController {

    @GetMapping
    public String getMain() {
        return "views/main";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "views/admin";
    }

    @GetMapping("/user")
    public String getUser() {
        return "views/user";
    }

    @GetMapping("/login")
    public String login() {
        return "views/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}
