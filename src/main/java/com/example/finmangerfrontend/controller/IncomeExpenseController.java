package com.example.finmangerfrontend.controller;

import com.example.finmangerfrontend.dto.IncomeExpenseManager;
import com.example.finmangerfrontend.service.IncomeExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/add-operation")
    public String sendNewIncomeExpense(IncomeExpenseManager incomeExpenseManager) {
        incomeExpenseService.sendNewIncomeExpense(incomeExpenseManager);
        return "redirect:/"; // here we are returning to main page without any repeated "calculations"
    }

    @GetMapping("/operations")
    public String showOperations(Model model) {
        System.out.println("Вошли на страницу");
        List<IncomeExpenseManager> operations = incomeExpenseService.getOperations();
        model.addAttribute("operations", operations);

        return "operations.html";
    }
}
