package com.example.asp.controllers;

import com.example.asp.dtos.CourseDto;
import com.example.asp.dtos.CreationCourseRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import com.example.asp.services.ProgramService;
import com.example.asp.models.Course;

import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private ProgramService business;

    @GetMapping("/")
    public List<CourseDto> getAllCourses(Model model) {
        return business.getCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable(name = "code") Long id) {
        var course = business.getCourse(id);
        return ResponseEntity.ok(course);
    }

    @PostMapping("/create-course")
    public ResponseEntity<Course> createCourse(
            @Valid @RequestBody CreationCourseRequest course,
            Errors errors, UriComponentsBuilder uriBuilder) {

        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        Course newCourse = business.addCourse(course);
        var uri = uriBuilder.path("/api/courses/{id}").buildAndExpand(newCourse.getId()).toUri();
        return ResponseEntity.created(uri).body(newCourse);
    }
}
