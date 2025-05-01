package com.example.asp.mappers;

import com.example.asp.dtos.StudentDto;
import com.example.asp.models.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto toDto(Student student);
}
