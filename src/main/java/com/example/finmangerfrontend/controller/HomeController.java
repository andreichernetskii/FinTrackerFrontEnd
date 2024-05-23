package com.example.finmangerfrontend.controller;

import com.example.finmangerfrontend.dto.Alert;
import com.example.finmangerfrontend.dto.FilterParameters;
import com.example.finmangerfrontend.dto.FinancialTransaction;
import com.example.finmangerfrontend.dto.Limit;
import com.example.finmangerfrontend.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// This class represents the controller for handling requests related to the home page.
@Controller
public class HomeController {
    private final FinancialTransactionService transactionService;
    private final LimitsService limitsService;
    private final CategoryService categoryService;
    private final AlertService alertService;
    private final LoginService loginService;

    public HomeController( FinancialTransactionService transactionService,
                           LimitsService limitsService,
                           CategoryService categoryService,
                           AlertService alertService,
                           LoginService loginService ) {

        this.transactionService = transactionService;
        this.limitsService = limitsService;
        this.categoryService = categoryService;
        this.alertService = alertService;
        this.loginService = loginService;
    }

    // Handler method for displaying the home page
    @GetMapping( "" )
    public String showHomePage( Model model, FilterParameters filterParameters ) {

        try {
            // Retrieving necessary information from backend services
            List<FinancialTransaction> financialTransactions = transactionService.getFinancialTransactions( filterParameters );
            Double totalAmount = transactionService.getAnnualBalance( filterParameters );
            List<String> categories = categoryService.getCategories();
            List<String> transactionTypes = transactionService.getTransactionTypes();
            List<Alert> alerts = alertService.getAlerts();
            List<Limit> limits = limitsService.getLimits();
            List<String> limitTypes = limitsService.getLimitTypes();
            String username = loginService.getUsernameForShow();

            // Adding information to the model
            model.addAttribute( "filter", filterParameters );
            model.addAttribute( "financialTransactions", financialTransactions );
            model.addAttribute( "totalAmount", totalAmount );
            model.addAttribute( "categories", categories );
            model.addAttribute( "transactionTypes", transactionTypes );
            model.addAttribute( "alerts", alerts );
            model.addAttribute( "limits", limits );
            model.addAttribute( "categories", categories );
            model.addAttribute( "limitTypes", limitTypes );
            model.addAttribute( "username", username );

            return "index";
        } catch ( Exception e ) {
            return "redirect:/login?error=true";
        }
    }

    // Financial transactions operations

    // Handler method for deleting a financial transaction
    @PostMapping( "/delete-transaction" )
    public String deleteFinancialTransaction( Long id ) {
        transactionService.deleteFinancialTransaction( id );
        return "redirect:/"; // Redirect to the home page after deletion
    }

    // Handler method for adding a new financial transaction
    @PostMapping( "/add-transaction" )
    public String sendNewFinancialTransaction( FinancialTransaction financialTransaction ) {
        transactionService.sendNewFinancialTransaction( financialTransaction );
        return "redirect:/"; // Redirect to the home page after addition
    }

    // Handler method for updating a financial transaction
    @PostMapping( "/update-transaction" )
    public String updateFinancialTransaction( FinancialTransaction financialTransaction ) {
        transactionService.updateFinancialTransaction( financialTransaction );
        return "redirect:/";
    }

    // Limits operations

    // Handler method for adding a new limit
    @PostMapping( "/add-new-limit" )
    public String addNewLimit( Limit limit ) {
        limitsService.addNewLimit( limit );
        return "redirect:/";
    }

    // Handler method for updating a limit
    @PostMapping( "/update-limit" )
    public String updateLimit( Limit limit ) {
        limitsService.updateLimit( limit );
        return "redirect:/";
    }

    // Handler method for deleting a limit
    @PostMapping( "/delete-limit" )
    public String deleteLimit( Long id ) {
        limitsService.deleteLimit( id );
        return "redirect:/";
    }
}
