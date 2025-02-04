package com.example.finmangerfrontend.controller;

import com.example.finmangerfrontend.dto.RegistrationForm;
import com.example.finmangerfrontend.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final LoginService loginService;

    public LoginController( LoginService loginService ) {
        this.loginService = loginService;
    }

    // login page section

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

    // registration page section

    @GetMapping( "/registration" )
    public String getRegistrationView( Model model ) {
        model.addAttribute( "form", new RegistrationForm() );
        return "registration";
    }

    @PostMapping( "/registration" )
    public String registerNewUser( RegistrationForm registrationForm ) {
        loginService.registerNewUser( registrationForm );

        return "redirect:/login";
    }

}
