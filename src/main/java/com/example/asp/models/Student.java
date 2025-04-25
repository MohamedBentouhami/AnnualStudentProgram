package com.example.asp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @GeneratedValue
    @Id
    private int id;
    private String name;
    @Enumerated
    private Gender gender;
    @Enumerated
    private Section section;

}
