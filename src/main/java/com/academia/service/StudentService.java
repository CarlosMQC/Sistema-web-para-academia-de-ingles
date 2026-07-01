package com.academia.service;

import com.academia.model.Role;
import com.academia.model.Student;
import com.academia.model.User;
import com.academia.repository.IGenericRepo;
import com.academia.repository.IStudentRepository;
import com.academia.repository.RoleRepository;
import com.academia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.ArrayList;

@Service
public class StudentService extends CRUDImpl<Student, Integer> implements IStudentService {

    @Autowired
    private IStudentRepository repo;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return repo;
    }

    @Override
    public Student save(Student student) throws Exception {
        Student savedStudent = super.save(student);

        User newUser = new User();
        newUser.setUsername(savedStudent.getDni());
        newUser.setPassword(passwordEncoder.encode(savedStudent.getDni()));
        newUser.setEnabled(true);
        
        Role studentRole = roleRepository.findById(2).orElseThrow(() -> new RuntimeException("Role STUDENT not found"));
        newUser.setRoles(new ArrayList<>(Arrays.asList(studentRole)));
        
        newUser.setStudent(savedStudent);
        
        userRepository.save(newUser);

        return savedStudent;
    }
}