package com.example.asp.exceptions;

public class GenericError extends RuntimeException {
    public GenericError(int codeError, String msg) {
        super("Error status : " + codeError + msg);
    }
}