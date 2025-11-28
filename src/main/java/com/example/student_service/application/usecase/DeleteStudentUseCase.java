package com.example.student_service.application.usecase;

import com.example.student_service.domain.repository.StudentRepository;
import com.example.student_service.presentation.exception.StudentNotFoundException;

public class DeleteStudentUseCase {

    private final StudentRepository repo;

    public DeleteStudentUseCase(StudentRepository repo) {
        this.repo = repo;
    }

    public void execute(String id) {
        var studentOpt = repo.findById(id);
        if (studentOpt.isEmpty()) {
            throw new StudentNotFoundException("Student not found with id: " + id);
        }

        repo.deleteById(id);
    }
}