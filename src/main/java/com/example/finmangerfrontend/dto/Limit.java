package com.example.finmangerfrontend.dto;

import java.math.BigDecimal;

public class Limit {
    private Long id;
    private BigDecimal limitAmount;
    private LimitType limitType;

    public Limit() {
    }

    public Limit( Long id, BigDecimal limitAmount, LimitType limitType ) {
        this.id = id;
        this.limitAmount = limitAmount;
        this.limitType = limitType;
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

    public void setId( Long id ) {
        this.id = id;
    }

    public void setLimitAmount( BigDecimal limitAmount ) {
        this.limitAmount = limitAmount;
    }

    public void setLimitType( LimitType limitType ) {
        this.limitType = limitType;
    }
}
