package com.example.student_service.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CreateStudentRequestDto (

        @NotBlank(message = "First name is required")
        String firstName,

        // lastName bukan mandatory
        String lastName,

        @NotBlank(message = "Birth date is required")
        String birthDate
) {
}
