package com.example.finmangerfrontend.configuration;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.util.Collection;

public class StatefulRestTemplateInterceptor implements ClientHttpRequestInterceptor {
    private String cookie;

    // catching cookies from response for next using
    @Override
    public ClientHttpResponse intercept( HttpRequest request, byte[] body, ClientHttpRequestExecution execution ) throws IOException {
        if ( cookie != null ) request.getHeaders().add( HttpHeaders.COOKIE, cookie );

        ClientHttpResponse response = execution.execute( request, body );

        if ( cookie == null ) cookie = response.getHeaders().getFirst( HttpHeaders.SET_COOKIE );

        return response;
    }
}
