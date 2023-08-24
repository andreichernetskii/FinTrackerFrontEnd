package com.example.finmangerfrontend.dto;

public class Alert {
    private String message;
    private boolean positive;

    public Alert() {    }

    public Alert( String message, boolean positive ) {
        this.message = message;
        this.positive = positive;
    }

    public String getMessage() {
        return message;
    }

    public boolean isPositive() {
        return positive;
    }
}
