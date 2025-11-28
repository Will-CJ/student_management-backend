package com.example.student_service.application.usecase;

import com.example.student_service.domain.model.Student;
import com.example.student_service.domain.repository.StudentRepository;
import com.example.student_service.application.command.UpdateStudentCommand;

import java.time.LocalDate;
import java.util.Optional;

public class UpdateStudentUseCase {

    private final StudentRepository repo;

    public UpdateStudentUseCase(StudentRepository repo) {
        this.repo = repo;
    }

    public Student execute(UpdateStudentCommand cmd) {
        Optional<Student> optional = repo.findById(cmd.id());
        if (optional.isEmpty()) {
            throw new RuntimeException("Student not found with id: " + cmd.id());
        }

        Student student = optional.get();

        Student updatedStudent = new Student(
                student.getId(),
                cmd.firstName() != null ? cmd.firstName() : student.getFirstName(),
                cmd.lastName() != null ? cmd.lastName() : student.getLastName(),
                cmd.birthDate() != null ? LocalDate.parse(cmd.birthDate()) : student.getBirthDate()
        );
        repo.save(updatedStudent);
        return updatedStudent;
    }
}
