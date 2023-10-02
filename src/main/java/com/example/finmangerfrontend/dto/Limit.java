package com.example.finmangerfrontend.dto;

import java.math.BigDecimal;

public class Limit {
    private LimitType limitType;
    private BigDecimal limitAmount;

    public Limit() {
    }

    public Limit( BigDecimal limitAmount, LimitType limitType ) {
        this.limitAmount = limitAmount;
        this.limitType = limitType;
    }

    public BigDecimal getLimitAmount() {
        return limitAmount;
    }

    public LimitType getLimitType() {
        return limitType;
    }

    public void setLimitAmount( BigDecimal limitAmount ) {
        this.limitAmount = limitAmount;
    }

    public void setLimitType( LimitType limitType ) {
        this.limitType = limitType;
    }
}
