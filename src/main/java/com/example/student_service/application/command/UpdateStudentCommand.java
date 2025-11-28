package com.example.student_service.application.command;

public record UpdateStudentCommand(
        String id,
        String firstName,
        String lastName,
        String birthDate
) {}
