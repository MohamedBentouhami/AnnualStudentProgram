package com.example.asp.exceptions;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(Long id){
        super("Student with ID " + id + " not found");
    }
}
