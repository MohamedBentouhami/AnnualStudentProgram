package com.example.asp.mappers;

import com.example.asp.dtos.CourseDto;
import com.example.asp.dtos.CreationCourseRequest;
import com.example.asp.models.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDto toDto(Course course);

    Course toEntity(CreationCourseRequest request);

}
