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

import com.academia.model.Enrollment;
import com.academia.service.IEnrollmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {
    private final IEnrollmentService service;
    
    @GetMapping 
    public List<Enrollment> findAll() throws Exception{
        return service.findAll();
    }
    
    @GetMapping("/{id}") 
    public Enrollment findById(@PathVariable("id") Integer id) throws Exception{
        return service.findById(id);
    }
    
    @PostMapping 
    public Enrollment save(@RequestBody Enrollment enrollment) throws Exception{
        return service.save(enrollment);
    }
    
    @PutMapping("/{id}") 
    public Enrollment update(@RequestBody Enrollment enrollment, @PathVariable("id") Integer id) throws Exception{
        return service.update(enrollment, id);
    }
    
    @DeleteMapping("/{id}") 
    public void delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
    }
}