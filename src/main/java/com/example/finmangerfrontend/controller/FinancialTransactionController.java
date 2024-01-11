package com.example.finmangerfrontend.controller;

import com.example.finmangerfrontend.dto.Alert;
import com.example.finmangerfrontend.dto.FilterParameters;
import com.example.finmangerfrontend.dto.FinancialTransaction;
import com.example.finmangerfrontend.service.AlertService;
import com.example.finmangerfrontend.service.FinancialTransactionService;
import com.example.finmangerfrontend.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//@Controller
public class FinancialTransactionController {
    private final FinancialTransactionService financialTransactionService;
    private final CategoryService categoryService;
    private final AlertService alertService;

    public FinancialTransactionController( FinancialTransactionService financialTransactionService, CategoryService categoryService, AlertService alertService ) {
        this.financialTransactionService = financialTransactionService;
        this.categoryService = categoryService;
        this.alertService = alertService;
    }

    @GetMapping( "/add-financial-transaction" )
    public String showAddIncomeExpensesFormPage() {
        return "add-financial-transaction";
    }

    @GetMapping( "/financial-transactions" )
    public String showOperationsByCriteria( Model model, FilterParameters filterParameters ) {
        List<FinancialTransaction> financialTransactions = financialTransactionService.getFinancialTransactions( filterParameters );
        Double totalAmount = financialTransactionService.getAnnualBalance( filterParameters );
        List<String> categories = categoryService.getCategories();
        List<Alert> alerts = alertService.getAlerts();

        model.addAttribute( "filter", filterParameters );
        model.addAttribute( "financialTransactions", financialTransactions );
        model.addAttribute( "totalAmount", totalAmount );
        model.addAttribute( "categories", categories );
        model.addAttribute( "alerts", alerts );
        return "financial-transactions.html";
    }

    @PostMapping( "/delete" )
    public String deleteOperation( Long id ) {
        financialTransactionService.deleteFinancialTransaction( id );
        return "redirect:/operations";
    }

    @PostMapping( "/add-transaction" )
    public String sendNewIncomeExpense( FinancialTransaction financialTransaction ) {
        financialTransactionService.senNewFinancialTransaction( financialTransaction );
        return "redirect:/"; // here we are returning to main page without any repeated "calculations"
    }

    @PostMapping( "/update-transaction" )
    public String updateIncomeExpense( FinancialTransaction financialTransaction ) {
        financialTransactionService.updateFinancialTransaction( financialTransaction );
        return "redirect:/operations";
    }
}
