package com.example.finmangerfrontend.dto;

import java.math.BigDecimal;

public class IncomeExpense {
    private Long id;
    private OperationType operationType;
    private BigDecimal amount;
    private String category;
    private String date; // todo: konwersia do odpowiedniego formatu: Date albo LocalDate

    public IncomeExpense() {
    }

    public IncomeExpense( Long id, OperationType operationType, BigDecimal amount, String category, String date ) {
        this.id = id;
        this.operationType = operationType;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    // getter'y są wymagane przez bibliotekę Jackson:

    public Long getId() {
        return id;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    // setter'y są potrzebne dla biblioteki Thymeleaf:

    public void setId( Long id ) {
        this.id = id;
    }

    public void setOperationType( OperationType operationType ) {
        this.operationType = operationType;
    }

    public void setAmount( BigDecimal amount ) {
        BigDecimal tempAmount = amount.abs();
        this.amount = ( operationType == OperationType.EXPENSE ) ? tempAmount.negate() : tempAmount;
    }

    public void setCategory( String category ) {
        this.category = category;
    }

    public void setDate( String date ) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "IncomeExpenseManager {" +
                "operationType=" + operationType +
                ", amount=" + amount +
                ", category='" + category + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

