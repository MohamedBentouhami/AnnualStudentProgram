package com.example.asp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.asp.business.Asp;

@Controller
public class CourseController {

    private Asp business;

    public CourseController(){
        business = new Asp();
    }

    @GetMapping("/courses")
    public String coursePage(Model model) {
        var courses = business.getCourses();
        model.addAttribute("courses", courses);
        return "courses";
    }
}
