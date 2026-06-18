package com.academia.service;

import com.academia.model.Student;
import com.academia.repo.IGenericRepo;
import com.academia.repo.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends CRUDImpl<Student, Integer> implements IStudentService {

    @Autowired
    private IStudentRepo repo;

    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return repo;
    }
}