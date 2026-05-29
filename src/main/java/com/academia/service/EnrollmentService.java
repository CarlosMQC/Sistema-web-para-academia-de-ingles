package com.academia.service;

import com.academia.model.Enrollment;
import com.academia.repository.IEnrollmentRepository;
import com.academia.repository.IGenericRepo;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService extends CRUDImpl<Enrollment, Integer> implements IEnrollmentService {

    private final IEnrollmentRepository repo;

    public EnrollmentService(IEnrollmentRepository repo) {
        this.repo = repo;
    }

    @Override
    protected IGenericRepo<Enrollment, Integer> getRepo() {
        return repo;
    }
}