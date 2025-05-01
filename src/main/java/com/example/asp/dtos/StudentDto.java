package com.example.asp.dtos;

import com.example.asp.models.Gender;
import com.example.asp.models.Section;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private Gender gender;
    private Section section;
}
