package com.example.asp.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.asp.model.Course;
import com.example.asp.model.Student;
import com.example.asp.repository.CourseDB;
import com.example.asp.repository.StudentDB;

@Service
public class Asp {
    @Autowired
    private CourseDB courseDB;
    @Autowired
    private StudentDB studentDB;

    public Iterable<Course> getCourses() {
        return courseDB.findAll();
    }

    public Course addCourse(Course course) {
        return courseDB.save(course);
    }

    public Iterable<Student> getStudents() {
        return studentDB.findAll();
    }
}
