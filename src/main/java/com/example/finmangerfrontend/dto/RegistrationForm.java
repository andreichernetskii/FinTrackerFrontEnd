package com.example.finmangerfrontend.dto;

public class RegistrationForm {
    private String username;
    private String password;
    private boolean demo;

    public String getUsername() {
        return username;
    }

    public void setUsername( String username ) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public boolean getDemo() {
        return demo;
    }

    public void setDemo( boolean demo ) {
        this.demo = demo;
    }
}
