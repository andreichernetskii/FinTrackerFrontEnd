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

@Controller
public class HomeController {
    private final FinancialTransactionService transactionService;
    private final LimitsService limitsService;
    private final CategoryService categoryService;
    private final AlertService alertService;

    public HomeController( FinancialTransactionService transactionService,
                           LimitsService limitsService,
                           CategoryService categoryService,
                           AlertService alertService ) {

        this.transactionService = transactionService;
        this.limitsService = limitsService;
        this.categoryService = categoryService;
        this.alertService = alertService;
    }

    @GetMapping( "" )
    public String showHomePage( Model model, FilterParameters filterParameters ) {

        // getting all information from backend
        List<FinancialTransaction> financialTransactions = transactionService.getFinancialTransactions( filterParameters );
        Double totalAmount = transactionService.getAnnualBalance( filterParameters );
        List<String> categories = categoryService.getCategories();
        List<String> transactionTypes = transactionService.getTransactionTypes();

        List<Alert> alerts = alertService.getAlerts();
        List<Limit> limits = limitsService.getLimits();
        List<String> limitTypes = limitsService.getLimitTypes();

        // adding information to a model
        model.addAttribute( "filter", filterParameters );
        model.addAttribute( "financialTransactions", financialTransactions );
        model.addAttribute( "totalAmount", totalAmount );
        model.addAttribute( "categories", categories );
        model.addAttribute( "transactionTypes", transactionTypes );

        model.addAttribute( "alerts", alerts );
        model.addAttribute( "limits", limits );
        model.addAttribute( "categories", categories );
        model.addAttribute( "limitTypes", limitTypes );

        return "index";
    }

    // financial transactions operations

    @PostMapping( "/delete-transaction" )
    public String deleteOperation( Long id ) {
        transactionService.deleteFinancialTransaction( id );
        return "redirect:/";
    }

    @PostMapping( "/add-transaction" )
    public String sendNewIncomeExpense( FinancialTransaction financialTransaction ) {
        transactionService.senNewFinancialTransaction( financialTransaction );
        return "redirect:/"; // here we are returning to main page without any repeated "calculations"
    }

    @PostMapping( "/update-transaction" )
    public String updateIncomeExpense( FinancialTransaction financialTransaction ) {
        transactionService.updateFinancialTransaction( financialTransaction );
        return "redirect:/";
    }

    // limits operations

    @PostMapping( "/add-new-limit" )
    public String addNewLimit( Limit limit ) {
        limitsService.addNewLimit( limit );
        return "redirect:/";
    }

    @PostMapping( "/update-limit" )
    public String updateLimit( Limit limit ) {
        limitsService.updateLimit( limit );
        return "redirect:/";
    }

    @PostMapping( "/delete-limit" )
    public String deleteLimit( Long id ) {
        limitsService.deleteLimit( id );
        return "redirect:/";
    }
}
