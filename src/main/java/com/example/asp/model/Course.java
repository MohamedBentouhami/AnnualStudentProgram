package com.example.asp.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @NotBlank(message = "Can't be empty")
    private String sigle;
    @NotBlank(message = "Can't be empty")
    private String title;
    @Min(value = 0, message = "should be positive")
    private int etc;
}
