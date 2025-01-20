package com.example.asp.model;

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
    @NotBlank(message = "Can't be empty")
    private String sigle;
    @NotBlank(message = "Can't be empty")
    private String title;
    @Min(value = 0, message = "should be positive")
    private int etc;
}
