package com.example.student_service.application.usecase;

import com.example.student_service.application.command.CreateStudentCommand;
import com.example.student_service.domain.model.Student;
import com.example.student_service.domain.repository.StudentRepository;


import java.time.LocalDate;
import java.util.UUID;


public class CreateStudentUseCase {


    private final StudentRepository repo;


    public CreateStudentUseCase(StudentRepository repo) {
        this.repo = repo;
    }


    public String execute(CreateStudentCommand cmd) {
        String id = UUID.randomUUID().toString();
        Student s = new Student(
                id,
                cmd.firstName(),
                cmd.lastName(),
                LocalDate.parse(cmd.birthDate())
        );
        repo.save(s);
        return id;
    }
}