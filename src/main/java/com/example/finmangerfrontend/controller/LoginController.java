package com.example.finmangerfrontend.controller;

import com.example.finmangerfrontend.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {

    private final LoginService loginService;

    public LoginController( LoginService loginService ) {
        this.loginService = loginService;
    }

    @GetMapping( "/login" )
    public String getLoginView() {
        return "login.html";
    }

    @PostMapping( "/login-request" )
    public String login( @RequestParam( "username" ) String username,
                         @RequestParam( "password" ) String password ) {

        loginService.login( username, password );

        return "redirect:/login";
    }
}
