package com.example.student_service.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.student_service.infrastructure.jpa.impl.*;
import com.example.student_service.application.usecase.*;
import com.example.student_service.domain.repository.StudentRepository;
import com.example.student_service.infrastructure.jpa.repository.*;


@Configuration
public class BeanConfig {


    @Bean
    public StudentRepository studentRepository(StudentJpaRepository jpaRepo) {
        return new StudentRepositoryImpl(jpaRepo);
    }


    @Bean
    public CreateStudentUseCase createStudentUseCase(StudentRepository repo) {
        return new CreateStudentUseCase(repo);
    }

    @Bean
    public UpdateStudentUseCase updateStudentUseCase(StudentRepository repo) {
        return new UpdateStudentUseCase(repo);
    }


    @Bean
    public ListAllStudentsUseCase listStudentsUseCase(StudentRepository repo) {
        return new ListAllStudentsUseCase(repo);
    }

    @Bean
    public DeleteStudentUseCase deleteStudentUseCase(StudentRepository repo) {
        return new DeleteStudentUseCase(repo);
    }
}
