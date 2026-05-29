package com.academia.service;

import com.academia.model.Course;
import com.academia.repository.ICourseRepository;
import com.academia.repository.IGenericRepo;
import org.springframework.stereotype.Service;

@Service
public class CourseService extends CRUDImpl<Course, Integer> implements ICourseService {

    private final ICourseRepository repo;

    public CourseService(ICourseRepository repo) {
        this.repo = repo;
    }

    @Override
    protected IGenericRepo<Course, Integer> getRepo() {
        return repo;
    }
}