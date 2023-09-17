package com.example.finmangerfrontend.controller;

import com.example.finmangerfrontend.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class LoginController {
    private final UserService userService;

    public LoginController( UserService userService ) {
        this.userService = userService;
    }

    public String createNewUser( Model model ) {
        return "index.html";
    }
}
