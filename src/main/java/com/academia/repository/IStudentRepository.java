package com.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.academia.model.Student;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
}