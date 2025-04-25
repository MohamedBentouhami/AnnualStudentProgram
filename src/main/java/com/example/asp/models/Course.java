package com.example.asp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    private Long id;
    @NotBlank(message = "Cannot be empty")
    private String code;
    @NotBlank(message = "Cannot be empty")
    private String title;
    @Min(value = 0, message = "Should be positive")
    private int etc;
}
