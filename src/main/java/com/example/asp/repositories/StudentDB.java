package com.example.asp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.asp.models.Student;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentDB extends JpaRepository<Student, Long> {
    @Query("SELECT s from Student s where :courseId NOT IN (SELECT c.id from s.courses c)")
    List<Student> findStudentNotSubscribed(Long courseId);
}
