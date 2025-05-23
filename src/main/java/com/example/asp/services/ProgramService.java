package com.example.asp.services;

import com.example.asp.dtos.*;
import com.example.asp.exceptions.GenericError;
import com.example.asp.exceptions.StudentNotFoundException;
import com.example.asp.mappers.CourseMapper;
import com.example.asp.mappers.StudentMapper;
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
    @Autowired
    private StudentMapper studentMapper;

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

    public List<StudentDto> getStudents() {
        return studentDB.findAll().stream().map(studentMapper::toDto).toList();
    }

    public StudentDto getStudent(Long id) {
        return studentMapper.toDto(studentDB.findById(id).orElse(null));
    }

    public Student addStudent(StudentCreationRequest student) {
        return studentDB.save(studentMapper.toEntity(student));
    }

    public boolean doesStudentExist(Long id) {
        return studentDB.existsById(id);
    }

    public List<StudentDto> getStudentsByCourse(Long courseId) {
        var course = getCourse(courseId);
        return course.getStudents().stream().map(studentMapper::toDto).toList();
    }

    public List<CourseDto> getCoursesByStudent(Long studentId) {
        Student student = studentDB.findById(studentId).orElse(null);
        return student.getCourses().stream().map(courseMapper::toDto).toList();
    }

    public void enrollStudent(StudentCourseIds studentCourseIds) {
        Student student = studentDB.findById(studentCourseIds.getStudentId())
                .orElseThrow(() -> new StudentNotFoundException(studentCourseIds.getStudentId()));
        Course course = courseDB.findById(studentCourseIds.getCourseId())
                .orElseThrow(() -> new GenericError(404, "Course not found"));

        if (!isAlreadySubscribed(student, course)) {
            student.getCourses().add(course);
            studentDB.save(student);
        }
    }

    private boolean isAlreadySubscribed(Student student, Course course) {
        return student.getCourses().stream().anyMatch(c -> c.getId().equals(course.getId()));
    }

    public List<StudentDto> getStudentsNotSubscribed(Long courseId) {
        var students = studentDB.findStudentNotSubscribed(courseId);
        return students.stream().map(studentMapper::toDto).toList();
    }

    public List<CourseDto> getCoursesNotEnrolled(Long studentId) {
        var students = courseDB.getNotEnrolledCourses(studentId);
        return students.stream().map(courseMapper::toDto).toList();
    }
}
