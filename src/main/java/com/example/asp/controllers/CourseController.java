package com.example.asp.controllers;

import com.example.asp.dtos.CreationCourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import com.example.asp.business.Asp;
import com.example.asp.models.Course;

import jakarta.validation.Valid;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private Asp business;

    @GetMapping("/")
    public List<Course> getAllCourses(Model model) {
        return business.getCourses();
    }

    @GetMapping("{id}")
    public ResponseEntity<Course> getCourse(@PathVariable(name = "code") Long id) {
        var course = business.getCourse(id);
        return ResponseEntity.ok(course);
    }

    @PostMapping("/create-course")
    public String createCourse(@RequestBody CreationCourseDto course, UriComponentsBuilder uriBuilder) {

        business.addCourse(course);
        return "redirect:/courses";
    }
}
