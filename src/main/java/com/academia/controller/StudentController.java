package com.academia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academia.model.Student;
import com.academia.service.IStudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final IStudentService service;
    
    @GetMapping 
    public List<Student> findAll() throws Exception{
        return service.findAll();
    }
    
    @GetMapping("/{id}") 
    public Student findById(@PathVariable("id") Integer id) throws Exception{
        return service.findById(id);
    }
    
    @PostMapping 
    public Student save(@RequestBody Student student) throws Exception{
        return service.save(student);
    }
    
    @PutMapping("/{id}") 
    public Student update(@RequestBody Student student, @PathVariable("id") Integer id) throws Exception{
        return service.update(student, id);
    }
    
    @DeleteMapping("/{id}") 
    public void delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
    }
}