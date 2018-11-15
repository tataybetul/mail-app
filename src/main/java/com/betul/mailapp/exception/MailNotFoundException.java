package com.betul.mailapp.exception;

public class MailNotFoundException extends RuntimeException {

    public MailNotFoundException(String message) {
        super(message);
    }

    public MailNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
