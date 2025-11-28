package com.example.student_service.presentation.exception;

public class StudentNotFoundException  extends RuntimeException {
    public StudentNotFoundException(String id) {
        super("Student with ID " + id + " not found");
    }
}
