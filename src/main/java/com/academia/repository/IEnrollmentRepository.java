package com.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.academia.model.Enrollment;

public interface IEnrollmentRepository extends JpaRepository<Enrollment, Integer> {
}