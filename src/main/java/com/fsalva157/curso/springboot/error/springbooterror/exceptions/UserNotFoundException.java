package com.fsalva157.curso.springboot.error.springbooterror.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message) {
        super(message);
    }
}
