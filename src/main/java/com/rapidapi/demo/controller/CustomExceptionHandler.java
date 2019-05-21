package com.rapidapi.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import com.rapidapi.demo.model.ErrorResponse;
 
@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class CustomExceptionHandler
{  
	private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);
    @ExceptionHandler(ServletRequestBindingException.class)
    public final ResponseEntity<Object> handleHeaderException(Exception ex, WebRequest request)
    {
        ErrorResponse error = new ErrorResponse("Bad Request", ex.getLocalizedMessage());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(HttpClientErrorException.class)
    public final ResponseEntity<Object> handleAllExceptions(HttpClientErrorException ex, WebRequest request)
    {
        ErrorResponse error = new ErrorResponse("X-RapidAPI-Key is not valid", ex.getLocalizedMessage());
        logger.error("X-RapidAPI-Key is not valid ");
        return new ResponseEntity(error, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(AuthenticationException.class)
    public final ResponseEntity<Object> handleAllExceptions(AuthenticationException ex, WebRequest request)
    {
        ErrorResponse error = new ErrorResponse("token is not valid", ex.getLocalizedMessage());
        logger.error("token is not valid ");
        return new ResponseEntity(error, HttpStatus.UNAUTHORIZED);
    }
    

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request)
    {
        ErrorResponse error = new ErrorResponse("Server Error", ex.getLocalizedMessage());
        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
