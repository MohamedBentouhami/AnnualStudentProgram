package com.example.asp.controllers;

import com.example.asp.dtos.CourseDto;
import com.example.asp.dtos.StudentCreationRequest;
import com.example.asp.dtos.StudentDto;
import com.example.asp.exceptions.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import com.example.asp.services.ProgramService;
import com.example.asp.models.Student;

import jakarta.validation.Valid;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {
    @Autowired
    private ProgramService business;

    @GetMapping("")
    public List<StudentDto> getAllStudents(Model model) {
        return business.getStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable Long id) {
        if (!business.doesStudentExist(id)) {
            throw new StudentNotFoundException(id);
        }
        var student = business.getStudent(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentCreationRequest student, UriComponentsBuilder uriBuilder) {
        Student newStudent = business.addStudent(student);
        var uri = uriBuilder.path("/api/students/{id}").buildAndExpand(newStudent.getId()).toUri();
        return ResponseEntity.created(uri).body(newStudent);
    }

    @GetMapping("{student_id}/courses")
    public ResponseEntity<List<CourseDto>> getCoursesByStudent(@PathVariable(name = "student_id") Long studentId) {
        var courses = business.getCoursesByStudent(studentId);
        return ResponseEntity.ok(courses);
    }


}
