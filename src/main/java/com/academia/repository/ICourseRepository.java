package com.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.academia.model.Course;

public interface ICourseRepository extends JpaRepository<Course, Integer> {
}