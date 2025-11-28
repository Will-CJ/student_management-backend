package com.example.student_service.application.usecase;

import com.example.student_service.domain.repository.StudentRepository;
import com.example.student_service.presentation.dto.response.StudentResponseDto;


import java.util.stream.Collectors;
import java.util.List;


public class ListAllStudentsUseCase {


    private final StudentRepository repo;


    public ListAllStudentsUseCase(StudentRepository repo) {
        this.repo = repo;
    }


    public List<StudentResponseDto> execute() {
        return repo.findAll().stream()
                .map(s -> new StudentResponseDto(s.getId(), s.getFullName(), s.getAge()))
                .collect(Collectors.toList());
    }
}
