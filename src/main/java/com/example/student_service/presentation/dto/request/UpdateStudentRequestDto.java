package com.example.student_service.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UpdateStudentRequestDto(
        @NotBlank(message = "Student ID is required")
        String id,

        @NotBlank(message = "First name is required")
        String firstName,

        String lastName,

        @NotBlank(message = "Birth date is required")
        String birthDate
) {}
