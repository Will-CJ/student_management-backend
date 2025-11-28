package com.example.student_service.infrastructure.jpa.impl;

import com.example.student_service.domain.model.Student;
import com.example.student_service.domain.repository.StudentRepository;
import com.example.student_service.infrastructure.jpa.entity.StudentEntity;
import com.example.student_service.infrastructure.jpa.repository.StudentJpaRepository;
import org.springframework.data.domain.Sort;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class StudentRepositoryImpl implements StudentRepository {


    private final StudentJpaRepository jpaRepo;


    public StudentRepositoryImpl(StudentJpaRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }


    @Override
    public void save(Student s) {
        StudentEntity entity = new StudentEntity(
                s.getId(),
                s.getFirstName(),
                s.getLastName(),
                s.getBirthDate()
        );
        jpaRepo.save(entity);
    }


    @Override
    public List<Student> findAll() {
        return jpaRepo.findAll(Sort.by("createdAt")).stream()
                .map(e -> new Student(e.getId(), e.getFirstName(), e.getLastName(), e.getBirthDate()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Student> findById(String id) {
        return jpaRepo.findById(id)
                .map(e -> new Student(
                        e.getId(),
                        e.getFirstName(),
                        e.getLastName(),
                        e.getBirthDate()
                ));
    }

    @Override
    public void deleteById(String id) {
        jpaRepo.deleteById(id);
    }
}
