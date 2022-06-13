package com.example.pernsonalDictionary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BlankFieldException extends RuntimeException{

    public BlankFieldException() {
    }

    public BlankFieldException(String message) {
        super(message);
    }
}
