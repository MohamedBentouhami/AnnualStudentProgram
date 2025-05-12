package com.example.asp.dtos;

import com.example.asp.models.Gender;
import com.example.asp.models.Section;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentCreationRequest {
    @NotBlank(message = "Name cannot be empty")
    private String name;
    private Gender gender;
    private Section section;
}
