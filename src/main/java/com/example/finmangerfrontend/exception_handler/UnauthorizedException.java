package com.example.finmangerfrontend.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( HttpStatus.UNAUTHORIZED )
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException() {
        super();
    }
}
