package com.example.finmangerfrontend.dto;

public class ApplicationUser {
    private String email;
    private String password;

    public ApplicationUser() {}

    public ApplicationUser( String email, String password ) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public void setPassword( String password ) {
        this.password = password;
    }
}
