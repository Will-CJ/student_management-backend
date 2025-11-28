package com.example.student_service.infrastructure.jpa.repository;

import com.example.student_service.infrastructure.jpa.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentJpaRepository extends JpaRepository<StudentEntity, String> {}
