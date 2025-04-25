package com.example.asp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.asp.business.Asp;
import com.example.asp.models.Student;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class StudentController {
    @Autowired
    private Asp business;

    @GetMapping("/students")
    public String students(Model model) {
        model.addAttribute("students", business.getStudents());
        model.addAttribute("student", new Student());
        return "students";
    }
    @PostMapping("/create-student")
    public String createStudent(@Valid Student student, Errors erros, Model model) {
        if(erros.hasErrors()){
            model.addAttribute("students", business.getStudents());
        }
        business.addStudent(student);
        return "redirect:/students";
    }
    
}
