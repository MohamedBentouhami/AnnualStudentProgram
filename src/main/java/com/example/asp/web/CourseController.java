package com.example.asp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.asp.business.Asp;

@Controller
public class CourseController {

    private Asp business;

    public CourseController(){
        business = new Asp();
    }

    @GetMapping("/courses")
    public String coursesPage(Model model) {
        var courses = business.getCourses();
        model.addAttribute("courses", courses);
        return "courses";
    }

    @GetMapping("/courses/{idCourse}")
    public String course(@PathVariable String idCourse){
        System.out.println(idCourse);
        return "course";
    }
}
