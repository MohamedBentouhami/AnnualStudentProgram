package com.example.asp.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.asp.model.Course;

public interface CourseDB extends CrudRepository<Course, String> {

}
