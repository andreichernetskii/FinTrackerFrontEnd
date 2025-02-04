package com.example.finmangerfrontend.configuration;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.util.List;

// Intercepts HTTP requests and responses to manage cookies
public class StatefulRestTemplateInterceptor implements ClientHttpRequestInterceptor {
    private String cookie;  // Stores the cookie received from the server
    private String responseBody;    // Stores the response body

    // Intercepts the HTTP request to add cookies if available
    @Override
    public ClientHttpResponse intercept( HttpRequest request, byte[] body, ClientHttpRequestExecution execution ) throws IOException {
        // Add stored cookie to request headers
        if ( cookie != null ) request.getHeaders().add( HttpHeaders.COOKIE, cookie );

        // Execute the HTTP request
        ClientHttpResponse response = execution.execute( request, body );
        // Get cookies from response headers
        List<String> cookies = response.getHeaders().get( HttpHeaders.SET_COOKIE );
        // Store the response body
        responseBody = response.getBody().toString();

        // Process received cookies
        if ( cookies != null ) {
            // Refresh cookies after every retrieval from the backend
            for ( String newCookie : cookies ) {
                if ( cookie == null || !cookie.contains( newCookie ) ) {
                    cookie = newCookie; // Update the stored cookie
                }
            }
        }

        return response;
    }

    public String getBody() {
        return responseBody;
    }
}
