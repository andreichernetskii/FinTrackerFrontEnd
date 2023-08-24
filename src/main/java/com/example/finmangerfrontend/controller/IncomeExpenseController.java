package com.example.finmangerfrontend.controller;

import com.example.finmangerfrontend.dto.FilterParameters;
import com.example.finmangerfrontend.dto.IncomeExpense;
import com.example.finmangerfrontend.service.IncomeExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class IncomeExpenseController {
    private final IncomeExpenseService incomeExpenseService;

    public IncomeExpenseController( IncomeExpenseService incomeExpenseService ) {
        this.incomeExpenseService = incomeExpenseService;
    }

    @GetMapping( "/add-operation" )
    public String showAddIncomeExpensesFormPage() {
        return "add-operation.html";
    }

    @GetMapping( "/operations" )
    public String showOperations( Model model ) {
        List<IncomeExpense> operations = incomeExpenseService.getOperations();
        Double totalAmount = incomeExpenseService.getAnnualBalance();
        model.addAttribute( "operations", operations );
        model.addAttribute( "totalAmount", totalAmount );
        return "operations.html";
    }

    @GetMapping( "/operations-statistics" )
    public String showOperationsByCriteria( Model model, FilterParameters filterParameters ) {
        List<IncomeExpense> operations = incomeExpenseService.getOperations( filterParameters );
        Double totalAmount = incomeExpenseService.getAnnualBalance( filterParameters );
        model.addAttribute( "operations", operations );
        model.addAttribute( "totalAmount", totalAmount );
        return "operations.html";
    }

//    @GetMapping( "/operations-annual" )
//    public String showAnnualBalance ( Model model, FilterParameters filterParameters ) {
//        Double totalAmount = incomeExpenseService.getAnnualBalance( filterParameters );
//        model.addAttribute( "totalAmount", totalAmount );
//        return "operations.html";
//    }

    @PostMapping( "/delete" )
    public String deleteOperation( Long id ) {
        incomeExpenseService.deleteOperation( id );
        return "redirect:/operations";
    }

    @PostMapping( "/add-operation" )
    public String sendNewIncomeExpense( IncomeExpense incomeExpense ) {
        incomeExpenseService.sendNewIncomeExpense( incomeExpense );
        return "redirect:/"; // here we are returning to main page without any repeated "calculations"
    }

    @PostMapping( "/update-operation" )
    public String updateIncomeExpense( IncomeExpense incomeExpense ) {
        incomeExpenseService.updateIncomeExpense( incomeExpense );
        return "redirect:/operations";
    }
}
