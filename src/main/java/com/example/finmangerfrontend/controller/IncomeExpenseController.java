package com.example.finmangerfrontend.controller;

import com.example.finmangerfrontend.dto.IncomeExpense;
import com.example.finmangerfrontend.service.IncomeExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        model.addAttribute( "operations", operations );
        return "operations.html";
    }

    @GetMapping( "/operations-statistics" )
    public String showOperationsByDemandVersionMap( Model model,
                                                    @RequestParam( required = false ) String year,
                                                    @RequestParam( required = false ) String month,
                                                    @RequestParam( required = false ) String operationType,
                                                    @RequestParam( required = false ) String category ) {
        Map<String, String> paramsMap = createHashMap( year, month, operationType, category );
        List<IncomeExpense> operations;
        if ( paramsMap.isEmpty() ) operations = incomeExpenseService.getOperations();
        operations = incomeExpenseService.getOperationsVersionMap( paramsMap );
        model.addAttribute( "operations", operations );
        return "operations.html";
    }

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

    // ADDITIONAL FUNCTIONS

    private Map<String, String> createHashMap( String year, String month, String operationType, String category ) {
        Map<String, String> paramsMap = new HashMap<>();
        if ( year != null && !year.equals( "" ) ) paramsMap.put( "year", year );
        if ( month != null && !month.equals( "" ) ) paramsMap.put( "month", month );
        if ( operationType != null ) paramsMap.put( "operationType", operationType );
        if ( category != null ) paramsMap.put( "category", category );
        return paramsMap;
    }
}
