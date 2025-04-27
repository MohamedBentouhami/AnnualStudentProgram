package com.example.asp.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreationCourseRequest {

    @NotBlank(message = "code cannot be empty")
    private String code;
    @NotBlank(message = "title cannot be empty")
    private String title;
    @Min(value = 0, message = "etc should be positive")
    private int etc;
}
