package com.example.finmangerfrontend.controller;

import com.example.finmangerfrontend.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController( LoginService loginService ) {
        this.loginService = loginService;
    }

//    @GetMapping()
//    public String getLoginView() {
//        return "login.html";
//    }

    @PostMapping( "/login" )
    public void login( @RequestParam( "username" ) String username,
                       @RequestParam( "password" ) String password ) {

        loginService.login( username, password );

//        return "redirect:/";
    }
}
