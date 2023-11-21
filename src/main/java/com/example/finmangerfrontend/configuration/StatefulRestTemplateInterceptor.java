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
import java.util.List;

public class StatefulRestTemplateInterceptor implements ClientHttpRequestInterceptor {
    private String cookie;

    // catching cookies from response for next using
    @Override
    public ClientHttpResponse intercept( HttpRequest request, byte[] body, ClientHttpRequestExecution execution ) throws IOException {
        if ( cookie != null ) request.getHeaders().add( HttpHeaders.COOKIE, cookie );

        ClientHttpResponse response = execution.execute( request, body );
        List<String> cookies = response.getHeaders().get( HttpHeaders.SET_COOKIE );

        if ( cookies != null ) {
            // refresh cookies after every getting them from backend
            for ( String newCookie : cookies ) {
                if ( cookie == null || !cookie.contains( newCookie ) ) {
                    cookie = newCookie;
                }
            }
        }

        return response;
    }
}
