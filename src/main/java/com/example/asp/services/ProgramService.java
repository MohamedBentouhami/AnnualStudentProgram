package com.example.asp.services;

import com.example.asp.dtos.CourseDto;
import com.example.asp.dtos.CreationCourseRequest;
import com.example.asp.mappers.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.asp.models.Course;
import com.example.asp.models.Student;
import com.example.asp.repositories.CourseDB;
import com.example.asp.repositories.StudentDB;

import java.util.List;

@Service
public class ProgramService {
    @Autowired
    private CourseDB courseDB;
    @Autowired
    private StudentDB studentDB;
    @Autowired
    private CourseMapper courseMapper;

    public List<CourseDto> getCourses() {
        var courses = courseDB.findAll();
        return courses.stream().map(courseMapper::toDto).toList();
    }

    public Course getCourse(Long id) {
        return courseDB.findById(id).orElse(null);
    }

    public Course addCourse(CreationCourseRequest newCourse) {
        var course = courseMapper.toEntity(newCourse);
        return courseDB.save(course);
    }

    public Iterable<Student> getStudents() {
        return studentDB.findAll();
    }

    public Student addStudent(Student student) {
        return studentDB.save(student);
    }
}
