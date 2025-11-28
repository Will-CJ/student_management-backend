package com.example.student_service.presentation.dto.response;

public record UpdateStudentResponseDto(
        String id,
        String firstName,
        String lastName,
        String birthDate
) {}
