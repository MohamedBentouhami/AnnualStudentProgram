package com.example.asp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.asp.models.Course;

import java.util.List;

public interface CourseDB extends JpaRepository<Course, Long> {
    @Query("SELECT c from Course c where :studentId NOT IN (select s.id from c.students s)")
    List<Course> getNotEnrolledCourses(Long studentId);
}
