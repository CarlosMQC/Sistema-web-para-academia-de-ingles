package com.academia.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.academia.model.Course;
import com.academia.repository.ICourseRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseService implements ICourseService {
    private final ICourseRepository repo;
    
    @Override
    public Course save(Course course) throws Exception {
        return repo.save(course);
    }

    @Override
    public Course update(Course course, Integer id) throws Exception {
        course.setIdCourse(id);
        return repo.save(course);
    }

    @Override
    public List<Course> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Course findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Course());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);    
    }
}