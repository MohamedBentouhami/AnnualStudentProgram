package com.example.asp.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.asp.model.Course;
import com.example.asp.repository.CourseDB;

@Service
public class Asp {
    @Autowired
    private CourseDB courseDB;

    public Iterable<Course> getCourses() {
        return courseDB.findAll();
    }
    public Course addCourse(Course course){
        return courseDB.save(course);
    }
}
