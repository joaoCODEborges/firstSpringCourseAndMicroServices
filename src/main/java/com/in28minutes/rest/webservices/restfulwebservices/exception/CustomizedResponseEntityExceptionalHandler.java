package com.in28minutes.rest.webservices.restfulwebservices.exception;


import com.in28minutes.rest.webservices.restfulwebservices.user.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice // will share for the multiple controller classes
@RestController // provides a response back in case of exceptions
public class CustomizedResponseEntityExceptionalHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class) // 500 status code
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    };

    @ExceptionHandler(UserNotFoundException.class) // 404 status code
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false)
        );

        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    };

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                "Validation Failed", //"Customizing the message for the consumer" (ex.getMessage() -> Generic Message),
                ex.getBindingResult().toString() //needs to give me binding back message result httpstatus 400
        );
                return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }


}
