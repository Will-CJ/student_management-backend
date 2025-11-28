package com.example.student_service.domain.repository;

import com.example.student_service.domain.model.Student;
import java.util.List;
import java.util.Optional;


public interface StudentRepository {
    void save(Student s);
    List<Student> findAll();

    Optional<Student> findById(String id);

    void deleteById(String id);
}
