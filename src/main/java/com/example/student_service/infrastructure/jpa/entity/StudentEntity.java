package com.example.student_service.infrastructure.jpa.entity;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Access(AccessType.FIELD)
@Table(name = "students")
public class StudentEntity {


    @Id
    private String id;

    @Column(nullable = false)
    private String firstName;

    private String lastName;

    @Column(nullable = false)
    private LocalDate birthDate;


    public StudentEntity() {}


    public StudentEntity(String id, String firstName, String lastName, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }


    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public LocalDate getBirthDate() { return birthDate; }
}
