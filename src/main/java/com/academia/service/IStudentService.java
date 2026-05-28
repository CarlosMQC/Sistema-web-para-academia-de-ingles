package com.academia.service;

import java.util.List;
import com.academia.model.Student;

public interface IStudentService {
    Student save(Student student) throws Exception;
    Student update(Student student, Integer id) throws Exception;
    List<Student> findAll() throws Exception;
    Student findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}