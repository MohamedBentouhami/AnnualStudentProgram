package com.example.asp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.asp.business.Asp;
import com.example.asp.model.Course;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CourseController {

    @Autowired
    private Asp business;

    @GetMapping("/courses")
    public String coursesPage(Model model) {
        var courses = business.getCourses();
        model.addAttribute("courses", courses);
        model.addAttribute("course", new Course());
        return "courses";
    }

    @GetMapping("/courses/{idCourse}")
    public String course(@PathVariable String idCourse) {
        return "course";
    }

    @PostMapping("/create-course")
    public String createCourse(@Valid Course course, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("courses", business.getCourses());
            return "courses";
        }
        business.addCourse(course);
        return "redirect:/courses";
    }
}
