package com.betul.mailapp.exception;

public class UserAlreadyException extends RuntimeException{

    public UserAlreadyException(String message) {
        super(message);
    }
}
