package com.example.asp.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentCourseIds {
    @NotNull(message = "Should not be null")
    private Long studentId;
    @NotNull(message = "Should not be null")
    private Long courseId;
}
