package com.example.finmangerfrontend.controller;

import com.example.finmangerfrontend.dto.Alert;
import com.example.finmangerfrontend.dto.FilterParameters;
import com.example.finmangerfrontend.dto.FinancialTransaction;
import com.example.finmangerfrontend.service.ApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FinancialTransactionController {
    private final ApiService apiService;

    public FinancialTransactionController( ApiService apiService ) {
        this.apiService = apiService;
    }

    @GetMapping( "/add-financial-transaction" )
    public String showAddIncomeExpensesFormPage() {
        return "add-financial-transaction";
    }

    @GetMapping( "/financial-transactions" )
    public String showOperationsByCriteria( Model model, FilterParameters filterParameters ) {
        List<FinancialTransaction> financialTransactions = apiService.getOperations( filterParameters );
        Double totalAmount = apiService.getAnnualBalance( filterParameters );
        List<String> categories = apiService.getCategories();
        List<Alert> alerts = apiService.getAlerts();

        model.addAttribute( "filter", filterParameters );
        model.addAttribute( "financialTransactions", financialTransactions );
        model.addAttribute( "totalAmount", totalAmount );
        model.addAttribute( "categories", categories );
        model.addAttribute( "alerts", alerts );
        return "financial-transactions.html";
    }

    @PostMapping( "/delete" )
    public String deleteOperation( Long id ) {
        apiService.deleteOperation( id );
        return "redirect:/operations";
    }

    @PostMapping( "/add-transaction" )
    public String sendNewIncomeExpense( FinancialTransaction financialTransaction ) {
        apiService.sendNewIncomeExpense( financialTransaction );
        return "redirect:/"; // here we are returning to main page without any repeated "calculations"
    }

    @PostMapping( "/update-transaction" )
    public String updateIncomeExpense( FinancialTransaction financialTransaction ) {
        apiService.updateIncomeExpense( financialTransaction );
        return "redirect:/operations";
    }
}
