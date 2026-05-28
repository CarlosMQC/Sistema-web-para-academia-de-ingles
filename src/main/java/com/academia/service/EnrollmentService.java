package com.academia.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.academia.model.Enrollment;
import com.academia.repository.IEnrollmentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnrollmentService implements IEnrollmentService {
    private final IEnrollmentRepository repo;
    
    @Override
    public Enrollment save(Enrollment enrollment) throws Exception {
        return repo.save(enrollment);
    }

    @Override
    public Enrollment update(Enrollment enrollment, Integer id) throws Exception {
        enrollment.setIdEnrollment(id);
        return repo.save(enrollment);
    }

    @Override
    public List<Enrollment> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Enrollment findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Enrollment());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);    
    }
}