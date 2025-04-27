package com.example.asp.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ErrorBody {
    private int status;
    private String message;
    private List<String> errors;
}
