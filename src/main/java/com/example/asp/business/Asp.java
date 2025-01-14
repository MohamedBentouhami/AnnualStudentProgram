package com.example.asp.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.asp.model.Course;

@Service
public class Asp {

    public List<Course> getCourses() {
        return new ArrayList<>(List.of(new Course("INT1", "Introductions", 10),
                new Course("MAT1", "Mathematics", 6),
                new Course("DEV1", "Development", 6),
                new Course("ENG1", "English", 6),
                new Course("SCI1", "Science", 6),
                new Course("HIS1", "History", 6),
                new Course("PHY1", "Physics", 6),
                new Course("CHE1", "Chemistry", 6),
                new Course("BIO1", "Biology", 6),
                new Course("CS1", "Computer Science", 6),
                new Course("ART1", "Art", 6)

        ));
    }
}
