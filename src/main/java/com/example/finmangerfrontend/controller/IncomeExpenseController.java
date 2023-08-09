package com.example.finmangerfrontend.controller;

import com.example.finmangerfrontend.dto.IncomeExpense;
import com.example.finmangerfrontend.service.IncomeExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IncomeExpenseController {
    private final IncomeExpenseService incomeExpenseService;

    public IncomeExpenseController(IncomeExpenseService incomeExpenseService) {
        this.incomeExpenseService = incomeExpenseService;
    }

    @GetMapping("/add-operation")
    public String showAddIncomeExpensesFormPage() {
        return "add-operation.html";
    }

    @GetMapping("/operations")
    public String showOperations(Model model) {
        List<IncomeExpense> operations = incomeExpenseService.getOperations();
        model.addAttribute("operations", operations);
        return "operations.html";
    }

    @GetMapping("/operations-statistics")
    public String showOperationsByDemand(Model model,
                                         @RequestParam(required = false) String year,
                                         @RequestParam(required = false) String month) {
        List<IncomeExpense> operations;
        if ((year == null || year.isEmpty()) && (month == null || month.isEmpty())) operations = incomeExpenseService.getOperations();
        else if (year == null || year.isEmpty()) operations = incomeExpenseService.getOperationsMonth(Integer.parseInt(month));
        else if (month == null || month.isEmpty()) operations = incomeExpenseService.getOperationsYear(Integer.parseInt(year));
        else operations = incomeExpenseService.getOperationsYearAndMonth(Integer.parseInt(year), Integer.parseInt(month));
        model.addAttribute("operations", operations);
        return "operations.html";
    }

    @PostMapping("/delete")
    public String deleteOperation(Long id) {
        incomeExpenseService.deleteOperation(id);
        return "redirect:/operations";
    }

    @PostMapping("/add-operation")
    public String sendNewIncomeExpense(IncomeExpense incomeExpense) {
        incomeExpenseService.sendNewIncomeExpense(incomeExpense);
        return "redirect:/"; // here we are returning to main page without any repeated "calculations"
    }

    @PostMapping("/update-operation")
    public String updateIncomeExpense(IncomeExpense incomeExpense) {
        incomeExpenseService.updateIncomeExpense(incomeExpense);
        return "redirect:/operations";
    }
}
