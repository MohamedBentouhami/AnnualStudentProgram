package com.example.asp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.asp.business.Asp;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class StudentController {
    @Autowired
    private Asp business;

    @GetMapping("/students")
    public String students(Model model) {
        model.addAttribute("students", business.getStudents());
        log.info(business.getStudents().toString());
        return "students";
    }
}
