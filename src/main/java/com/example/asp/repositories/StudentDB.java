package com.example.asp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.asp.models.Student;

public interface StudentDB extends JpaRepository<Student, Integer> {

}
