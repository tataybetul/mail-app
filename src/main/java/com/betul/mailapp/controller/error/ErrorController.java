package com.betul.mailapp.controller.error;

import com.betul.mailapp.exception.*;
import com.betul.mailapp.mapper.ExceptionMessageMapper;
import com.betul.mailapp.model.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
public class ErrorController {

    private final ExceptionMessageMapper exceptionMessageMapper;

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorResponse responseException(HttpServletRequest request, HttpServletResponse response, Exception exception) {
        ErrorResponse errorResponse = exceptionMessageMapper.mapException(exception);
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return errorResponse;
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    public ErrorResponse responseException(HttpServletRequest request, HttpServletResponse response, UserNotFoundException exception) {
        ErrorResponse errorResponse = exceptionMessageMapper.mapException(exception);
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return errorResponse;
    }

    @ExceptionHandler(UserAlreadyException.class)
    @ResponseBody
    public ErrorResponse responseException(HttpServletRequest request, HttpServletResponse response, UserAlreadyException exception) {
        ErrorResponse errorResponse = exceptionMessageMapper.mapException(exception);
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return errorResponse;
    }

    @ExceptionHandler(MailNotFoundException.class)
    @ResponseBody
    public ErrorResponse responseException(HttpServletRequest request, HttpServletResponse response, MailNotFoundException exception) {
        ErrorResponse errorResponse = exceptionMessageMapper.mapException(exception);
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return errorResponse;
    }


    @ExceptionHandler(UserGenericException.class)
    @ResponseBody
    public ErrorResponse responseException(HttpServletRequest request, HttpServletResponse response, UserGenericException exception) {
        ErrorResponse errorResponse = exceptionMessageMapper.mapException(exception);
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return errorResponse;
    }

    @ExceptionHandler(MailGenericException.class)
    @ResponseBody
    public ErrorResponse responseException(HttpServletRequest request, HttpServletResponse response, MailGenericException exception) {
        ErrorResponse errorResponse = exceptionMessageMapper.mapException(exception);
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return errorResponse;
    }
}
