package com.example.asp.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreationCourseRequest {

    @NotBlank(message = "Cannot be empty")
    private String code;
    @NotBlank(message = "Cannot be empty")
    private String title;
    @Min(value = 0, message = "Should be positive")
    private int etc;
}
