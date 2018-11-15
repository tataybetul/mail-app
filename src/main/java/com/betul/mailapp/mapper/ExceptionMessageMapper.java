package com.betul.mailapp.mapper;

import com.betul.mailapp.model.ErrorResponse;
import org.springframework.stereotype.Component;

@Component
public class ExceptionMessageMapper {

    public ErrorResponse mapException(Exception exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setType(exception.getClass().getSimpleName());
        return errorResponse;
    }
}
