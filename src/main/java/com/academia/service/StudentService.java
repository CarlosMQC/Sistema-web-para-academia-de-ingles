package com.academia.service;

import com.academia.model.Student;
import com.academia.repository.IGenericRepo;
import com.academia.repository.IStudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends CRUDImpl<Student, Integer> implements IStudentService {

    private final IStudentRepository repo;

    public StudentService(IStudentRepository repo) {
        this.repo = repo;
    }

    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return repo;
    }
}