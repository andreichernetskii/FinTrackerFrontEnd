package com.example.finmangerfrontend.controller;

import com.example.finmangerfrontend.dto.Limit;
import com.example.finmangerfrontend.service.LimitsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LimitsController {
    private final LimitsService limitsService;

    public LimitsController( LimitsService limitsService ) {
        this.limitsService = limitsService;
    }

    @GetMapping( "/limits" )
    public String showLimits( Model model ) {
        List<Limit> limits = limitsService.getLimits();
        model.addAttribute( "limits", limits );
        return "limits.html";
    }
}
