package com.example.finmangerfrontend.service;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserService implements AuthenticationProvider {
    RestTemplate restTemplate;
    InMemoryUserDetailsManager manager;
    PasswordEncoder passwordEncoder;
    UserDetails user;

    // todo: userService robi zapytanie do endpoint LOGIN wstawiając hasło i login
    // jeśli bląd to AuthentificationFalse,
    // jeśli ok, to dodaje użytkownika do InMemoryUserDetailsManager,
    // żeby zapamiętać login i hasło w sessii
    // ten UserServise będzie używany w innych serwisach dla dożucania logina i hasła
    // do nagłówków
    // albo będze konfigórował RestTeplate to robił

    public UserService( RestTemplate restTemplate, PasswordEncoder passwordEncoder ) {
        this.restTemplate = restTemplate;
        this.manager = configureUserManager( passwordEncoder );
    }

    public InMemoryUserDetailsManager configureUserManager( PasswordEncoder passEncoder) {
         user = new User( "user1", passEncoder.encode( "123" ), new ArrayList<>() );
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager( user );
        return manager;
    }

   /* @Override
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {
        User user = restTemplate.getForObject(  )
        User user = userRepository.findById( username )
                .orElseThrow(() -> new UsernameNotFoundException( "User nie istnieje!" ));
        UserDetails user1 = new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), new ArrayList<>() );

        return user1;
    }*/

    @Override
    public Authentication authenticate( Authentication authentication ) throws AuthenticationException {
        return new Authentication() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return new ArrayList<>();
            }

            @Override
            public Object getCredentials() {
                return "abc";
            }

            @Override
            public Object getDetails() {
                return new Object();
            }

            @Override
            public Object getPrincipal() {
                return user;
            }

            @Override
            public boolean isAuthenticated() {
                return true;
            }

            @Override
            public void setAuthenticated( boolean isAuthenticated ) throws IllegalArgumentException {

            }

            @Override
            public String getName() {
                return "user";
            }
        };
    }

    @Override
    public boolean supports( Class<?> authentication ) {
        return true;
    }
}

/*
* Backend musi otrzymywać przy każdym zapytaniu login i hasło w headerach
* Na froncie kazdy serwis ktory robi zapytania musi komunikować się z jakimś serwisem od logowania po login i haslo
* Przy logowaniu security musi stworzyć Ci użytkownika jako obiekt w pamięci aplikacji który będzie pamiętał ten login i hasło
*  login form -> procesuje logowanie przy użyciu backendu nie hashując hasła!
* */
