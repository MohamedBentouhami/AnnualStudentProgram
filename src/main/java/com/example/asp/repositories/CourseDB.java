package com.example.asp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.asp.models.Course;

public interface CourseDB extends JpaRepository<Course, Long> {

}
