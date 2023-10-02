package com.example.finmangerfrontend.controller;

import com.example.finmangerfrontend.dto.Alert;
import com.example.finmangerfrontend.dto.FilterParameters;
import com.example.finmangerfrontend.dto.Operation;
import com.example.finmangerfrontend.service.ApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OperationController {
    private final ApiService apiService;

    public OperationController( ApiService apiService ) {
        this.apiService = apiService;
    }

    @GetMapping( "/add-operation" )
    public String showAddIncomeExpensesFormPage() {
        return "add-operation.html";
    }

    @GetMapping( "/operations" )
    public String showOperationsByCriteria( Model model, FilterParameters filterParameters ) {
        List<Operation> operations = apiService.getOperations( filterParameters );
        Double totalAmount = apiService.getAnnualBalance( filterParameters );
        List<String> categories = apiService.getCategories();
        List<Alert> alerts = apiService.getAlerts();

        model.addAttribute( "filter", filterParameters );
        model.addAttribute( "operations", operations );
        model.addAttribute( "totalAmount", totalAmount );
        model.addAttribute( "categories", categories );
        model.addAttribute( "alerts", alerts );
        return "operations.html";
    }

    @PostMapping( "/delete" )
    public String deleteOperation( Long id ) {
        apiService.deleteOperation( id );
        return "redirect:/operations";
    }

    @PostMapping( "/add-operation" )
    public String sendNewIncomeExpense( Operation operation ) {
        apiService.sendNewIncomeExpense( operation );
        return "redirect:/"; // here we are returning to main page without any repeated "calculations"
    }

    @PostMapping( "/update-operation" )
    public String updateIncomeExpense( Operation operation ) {
        apiService.updateIncomeExpense( operation );
        return "redirect:/operations";
    }
}
