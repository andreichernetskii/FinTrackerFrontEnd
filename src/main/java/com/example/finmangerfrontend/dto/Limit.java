package com.example.finmangerfrontend.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Limit {
    private Long id;
    private LimitType limitType;
    private BigDecimal limitAmount;
    private String category;
    private LocalDate creationDate;

    public Limit() {
    }

    public Limit( Long id, LimitType limitType, BigDecimal limitAmount, String category, LocalDate creationDate ) {
        this.id = id;
        this.limitType = limitType;
        this.limitAmount = limitAmount;
        this.category = category;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getLimitAmount() {
        return limitAmount;
    }

    public LimitType getLimitType() {
        return limitType;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public void setLimitAmount( BigDecimal limitAmount ) {
        this.limitAmount = limitAmount;
    }

    public void setLimitType( LimitType limitType ) {
        this.limitType = limitType;
    }

    public void setCategory( String category ) {
        this.category = category;
    }

    public void setCreationDate( LocalDate creationDate ) {
        this.creationDate = creationDate;
    }
}
