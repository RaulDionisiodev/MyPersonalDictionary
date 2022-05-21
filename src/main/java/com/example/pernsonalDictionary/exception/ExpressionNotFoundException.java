package com.example.pernsonalDictionary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ExpressionNotFoundException extends RuntimeException {

    public ExpressionNotFoundException(){};

    public ExpressionNotFoundException(String message){
        super(message);
    }

}
