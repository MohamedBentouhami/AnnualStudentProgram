package com.example.asp.business;

import com.example.asp.dtos.CreationCourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.asp.models.Course;
import com.example.asp.models.Student;
import com.example.asp.repositories.CourseDB;
import com.example.asp.repositories.StudentDB;

import java.util.List;

@Service
public class Asp {
    @Autowired
    private CourseDB courseDB;
    @Autowired
    private StudentDB studentDB;

    public List<Course> getCourses() {
        return courseDB.findAll();
    }

    public Course getCourse(Long id) {
        return courseDB.findById(id).orElse(null);
    }

    public Course addCourse(CreationCourseDto course) {

        return courseDB.save(course);
    }

    public Iterable<Student> getStudents() {
        return studentDB.findAll();
    }

    public Student addStudent(Student student) {
        return studentDB.save(student);
    }
}
