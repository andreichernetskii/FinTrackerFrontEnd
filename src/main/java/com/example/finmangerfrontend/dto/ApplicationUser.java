package com.example.finmangerfrontend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationUser {
    private String email;
    private String password;
    private boolean demo;

    public ApplicationUser( String email, String password ) {
        this.email = email;
        this.password = password;
    }
}
