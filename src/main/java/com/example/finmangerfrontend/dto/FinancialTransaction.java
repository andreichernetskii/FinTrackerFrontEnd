package com.example.finmangerfrontend.dto;

import java.math.BigDecimal;

public class FinancialTransaction {
    private Long id;
    private FinancialTransactionType financialTransactionType;
    private BigDecimal amount;
    private String category;
    private String date;

    public FinancialTransaction() {
    }

    public FinancialTransaction( Long id, FinancialTransactionType financialTransactionType, BigDecimal amount, String category, String date ) {
        this.id = id;
        this.financialTransactionType = financialTransactionType;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    // getter'y są wymagane przez bibliotekę Jackson:

    public Long getId() {
        return id;
    }

    public FinancialTransactionType getFinancialTransactionType() {
        return financialTransactionType;
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

    public void setFinancialTransactionType( FinancialTransactionType financialTransactionType ) {
        this.financialTransactionType = financialTransactionType;
    }

    public void setAmount( BigDecimal amount ) {
        BigDecimal tempAmount = amount.abs();
        this.amount = ( this.financialTransactionType == FinancialTransactionType.EXPENSE ) ? tempAmount.negate() : tempAmount;
    }

    public void setCategory( String category ) {
        this.category = category;
    }

    public void setDate( String date ) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "FinancialTransactionManager {" +
                "financialTransactionType=" + financialTransactionType +
                ", amount=" + amount +
                ", category='" + category + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

