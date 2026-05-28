package com.academia.service;

import java.util.List;
import com.academia.model.Course;

public interface ICourseService {
    Course save(Course course) throws Exception;
    Course update(Course course, Integer id) throws Exception;
    List<Course> findAll() throws Exception;
    Course findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}