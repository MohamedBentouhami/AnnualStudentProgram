package com.example.asp.controllers;

import com.example.asp.dtos.CourseDto;
import com.example.asp.dtos.CreationCourseRequest;
import com.example.asp.dtos.StudentCourseIds;
import com.example.asp.dtos.StudentDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.asp.services.ProgramService;
import com.example.asp.models.Course;

import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "http://localhost:5173")
public class CourseController {

    @Autowired
    private ProgramService business;

    @GetMapping("")
    public List<CourseDto> getAllCourses(Model model) {
        return business.getCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable(name = "id") Long id) {
        var course = business.getCourse(id);
        return ResponseEntity.ok(course);
    }

    @PostMapping("/create")
    public ResponseEntity<Course> createCourse(
            @Valid @RequestBody CreationCourseRequest course, UriComponentsBuilder uriBuilder) {
        Course newCourse = business.addCourse(course);
        var uri = uriBuilder.path("/api/courses/{id}").buildAndExpand(newCourse.getId()).toUri();
        return ResponseEntity.created(uri).body(newCourse);
    }

    @GetMapping("/{course_id}/students")
    public ResponseEntity<List<StudentDto>> getStudentsByCourse(@PathVariable(name = "course_id") Long courseId) {
        List<StudentDto> students = business.getStudentsByCourse(courseId);
        return ResponseEntity.ok(students);
    }

    @PatchMapping("add-student")
    public ResponseEntity<String> addStudentToCourse(@Valid @RequestBody StudentCourseIds studentCourseIds) {
        business.enrollStudent(studentCourseIds);
        return ResponseEntity.ok("Student added successfully");
    }

    @GetMapping("not-enrolled/{student-id}")
    public ResponseEntity<List<CourseDto>> getNotEnrolledCourses(@PathVariable(name = "student-id") Long studentId) {
        var courses = business.getCoursesNotEnrolled(studentId);
        return ResponseEntity.ok(courses);
    }
}
