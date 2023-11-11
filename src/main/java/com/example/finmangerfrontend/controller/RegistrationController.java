package com.example.finmangerfrontend.controller;

import com.example.finmangerfrontend.dto.ApplicationUser;
import com.example.finmangerfrontend.service.ApplicationUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

//@Controller
public class RegistrationController {
    private final ApplicationUserService applicationUserService;

    public RegistrationController( ApplicationUserService applicationUserService ) {
        this.applicationUserService = applicationUserService;
    }

    public String showRegistrationForm( Model model ) {
        model.addAttribute( "user", new ApplicationUser() );
        return "/registration";
    }

//    @PostMapping("/registration")
//    public String createNewUser( ApplicationUser applicationUser ) {
//        applicationUserService.addNewUser( applicationUser );
//        return "index.html";
//    }
}
