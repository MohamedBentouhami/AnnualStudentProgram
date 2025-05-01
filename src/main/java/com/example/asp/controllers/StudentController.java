package com.example.asp.controllers;

import com.example.asp.dtos.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import com.example.asp.services.ProgramService;
import com.example.asp.models.Student;

import jakarta.validation.Valid;

import java.util.List;


@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {
    @Autowired
    private ProgramService business;

    @GetMapping("/")
    public List<StudentDto> getAllStudents(Model model) {
        return business.getStudents();
    }

    @PostMapping("/create-student")
    public String createStudent(@Valid Student student, Errors erros, Model model) {
        if (erros.hasErrors()) {
            model.addAttribute("students", business.getStudents());
        }
        business.addStudent(student);
        return "redirect:/students";
    }

}
