package com.example.pernsonalDictionary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public final ResponseEntity<StandardError> handleUserAlreadyExistsException(Exception ex, WebRequest webRequest){
        StandardError standardError = new StandardError(
                "Username indisponível", new Date());
        return new ResponseEntity<>(standardError, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BlankFieldException.class)
    public final ResponseEntity<StandardError> handleBlankFieldException(Exception ex, WebRequest webRequest){
        StandardError standardError = new StandardError(
                "Os campos não podem ficar em branco", new Date());
        return new ResponseEntity<>(standardError, HttpStatus.CONFLICT);
    }
}
