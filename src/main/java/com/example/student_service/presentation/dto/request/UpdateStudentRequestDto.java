package com.example.student_service.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UpdateStudentRequestDto(
        @NotBlank(message = "Student ID is required")
        String id,

        String firstName,  // optional update
        String lastName,   // optional update
        String birthDate   // optional update, format: yyyy-MM-dd
) {}
