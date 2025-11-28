package com.example.student_service.presentation.dto.response;

public class StudentResponseDto {
    public String id;
    public String fullName;
    public int age;


    public StudentResponseDto(String id, String fullName, int age) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
    }
}