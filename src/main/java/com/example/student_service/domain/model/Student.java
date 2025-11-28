package com.example.student_service.domain.model;

import java.time.LocalDate;
import java.time.Period;


public class Student {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;


    public Student(String id, String firstName, String lastName, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }


    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getFullName() {
        return firstName + (lastName != null ? " " + lastName : "");
    }


    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}