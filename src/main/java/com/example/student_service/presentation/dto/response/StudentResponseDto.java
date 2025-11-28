package com.example.student_service.presentation.dto.response;

public class StudentResponseDto {
    public String id;
    public String firstName;
    public String lastName;
    public String birthDate;
    public String fullName;
    public int age;


    public StudentResponseDto(String id, String firstName, String lastName, String birthDate, String fullName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.fullName = fullName;
        this.age = age;
    }
}