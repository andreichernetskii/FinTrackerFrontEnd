package com.example.finmangerfrontend.service;

import com.example.finmangerfrontend.dto.ApplicationUser;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;

//@Service
public class ApplicationUserService implements UserDetailsService {
//    private final RestTemplate restTemplate;
//    private PasswordEncoder passwordEncoder;
//
//    public ApplicationUserService( RestTemplate restTemplate, PasswordEncoder passwordEncoder ) {
//        this.restTemplate = restTemplate;
//        this.passwordEncoder = passwordEncoder;
//    }

    @Override
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {
        return null;
    }

// todo: userService robi zapytanie do endpoint LOGIN wstawiając hasło i login
    // jeśli bląd to AuthentificationFalse,
    // jeśli ok, to dodaje użytkownika do InMemoryUserDetailsManager,
    // żeby zapamiętać login i hasło w sessii
    // ten UserServise będzie używany w innych serwisach dla dożucania logina i hasła
    // do nagłówków
    // albo będze konfigórował RestTeplate to robił




}

/*
* Backend musi otrzymywać przy każdym zapytaniu login i hasło w headerach
* Na froncie kazdy serwis ktory robi zapytania musi komunikować się z jakimś serwisem od logowania po login i haslo
* Przy logowaniu security musi stworzyć Ci użytkownika jako obiekt w pamięci aplikacji który będzie pamiętał ten login i hasło
*  login form -> procesuje logowanie przy użyciu backendu nie hashując hasła!
* */
