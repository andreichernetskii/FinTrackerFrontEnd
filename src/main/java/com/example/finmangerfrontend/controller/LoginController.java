package com.example.finmangerfrontend.controller;

import com.example.finmangerfrontend.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private final LoginService loginService;

    public LoginController( LoginService loginService ) {
        this.loginService = loginService;
    }

    @GetMapping( "/login" )
    public String getLoginView() {
        return "login";
    }

    @PostMapping( "/login-processing" )
    public String login( @RequestParam( "username" ) String username,
                       @RequestParam( "password" ) String password ) {

        loginService.login( username, password );
        return "redirect:/";
    }

    @PostMapping( "/logout-user" )
    public String logoutUser() {
        loginService.logoutUser();
        return "redirect:/login";
    }
}
