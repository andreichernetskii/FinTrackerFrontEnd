package com.example.finmangerfrontend.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.naming.AuthenticationException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
//    @ExceptionHandler( HttpClientErrorException.class )
//    protected ResponseEntity<?> handleForbiddenConflict( HttpClientErrorException exception ) {
//        String message = exception.getMessage();
//        return ResponseEntity.status( HttpStatus.FORBIDDEN ).body( message );
//    }

//    @ExceptionHandler( HttpClientErrorException.class )
//    public ModelAndView handleHttpClientErrorException( HttpClientErrorException exception ) {
//        HttpStatus statusCode = ( HttpStatus ) exception.getStatusCode();
//        ModelAndView modelAndView;
//
//        if ( statusCode == HttpStatus.UNAUTHORIZED ) {
//            modelAndView = new ModelAndView( "redirect:/login?error=true" );
//            modelAndView.addObject( "errorMessage", exception.getMessage() );
//        } else {
//            modelAndView = new ModelAndView( "error" );
//            modelAndView.addObject( "error", exception.getMessage() );
//        }
//
//        return modelAndView;
//    }

    @ExceptionHandler( HttpClientErrorException.class )
    public String handleAuthenticationException( HttpClientErrorException exception, Model model ) {
        HttpStatus statusCode = ( HttpStatus ) exception.getStatusCode();
        if ( statusCode == HttpStatus.UNAUTHORIZED || statusCode == HttpStatus.FORBIDDEN ) {
            model.addAttribute( "errorMessage", exception.getMessage() );
            return "redirect:/login?error=true";
        }
        return "redirect:/";
    }
}
