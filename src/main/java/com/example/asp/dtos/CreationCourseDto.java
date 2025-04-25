package com.example.asp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreationCourseDto {
    private String code;
    private String title;
    private int etc;
}
