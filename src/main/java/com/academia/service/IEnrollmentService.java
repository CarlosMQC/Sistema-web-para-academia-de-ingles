package com.academia.service;

import java.util.List;
import com.academia.model.Enrollment;

public interface IEnrollmentService {
    Enrollment save(Enrollment enrollment) throws Exception;
    Enrollment update(Enrollment enrollment, Integer id) throws Exception;
    List<Enrollment> findAll() throws Exception;
    Enrollment findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}