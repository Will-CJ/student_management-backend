package com.example.student_service.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;

public record DeleteStudentRequestDto(
        @NotBlank(message = "Student ID is required")
        String id
) {}
