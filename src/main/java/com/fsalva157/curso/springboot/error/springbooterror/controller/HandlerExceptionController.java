package com.fsalva157.curso.springboot.error.springbooterror.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.fsalva157.curso.springboot.error.springbooterror.exceptions.UserNotFoundException;
import com.fsalva157.curso.springboot.error.springbooterror.models.ErrorDto;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ErrorDto> divisionByZero(Exception e){
        ErrorDto error = new ErrorDto();
        error.setMessage(e.getMessage());
        error.setError("Division by zero");
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.setDate(new Date());
        return ResponseEntity.internalServerError().body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> numberFormatError(Exception ex){
        //este map creado con of es inmutable
        // Map<String, Object> error = Map.of("message", ex.getMessage(), "error", "Number format error", "status", HttpStatus.INTERNAL_SERVER_ERROR.value(), "date", new Date());
        //para este ejemplo usemos un map mutable
        Map<String, Object> error = new HashMap<>();
        error.put("message", ex.getMessage());
        error.put("error", "Number format error");
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.put("date", new Date());


        return error;
    }


    @ExceptionHandler({NullPointerException.class, HttpMessageNotWritableException.class, UserNotFoundException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> userNotFoundEx(Exception e){
        Map<String, Object> error = new HashMap<>();
        error.put("message", e.getMessage());
        error.put("error", "User o Role not found");
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.put("date", new Date());

        return error;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorDto> notFoundHandlerEx(Exception e){
        ErrorDto error = new ErrorDto();
        error.setDate(new Date());
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setError("Not found handler");

        return ResponseEntity.status(404).body(error);
    }

}
