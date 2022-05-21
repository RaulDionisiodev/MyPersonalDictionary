package com.example.pernsonalDictionary.exception;

public class ExpressionNotFoundException extends RuntimeException {

    public ExpressionNotFoundException(){};

    public ExpressionNotFoundException(String message){
        super(message);
    }

}
