package com.academia.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.academia.model.Student;
import com.academia.repository.IStudentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {
    private final IStudentRepository repo;
    
    @Override
    public Student save(Student student) throws Exception {
        return repo.save(student);
    }

    @Override
    public Student update(Student student, Integer id) throws Exception {
        student.setIdStudent(id);
        return repo.save(student);
    }

    @Override
    public List<Student> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Student findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Student());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);    
    }
}