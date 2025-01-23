package com.example.asp.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.asp.model.Student;

public interface StudentDB extends CrudRepository<Student, Integer> {

}
