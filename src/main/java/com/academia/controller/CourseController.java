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

import com.academia.model.Course;
import com.academia.service.ICourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    private final ICourseService service;
    
    @GetMapping 
    public List<Course> findAll() throws Exception{
        return service.findAll();
    }
    
    @GetMapping("/{id}") 
    public Course findById(@PathVariable("id") Integer id) throws Exception{
        return service.findById(id);
    }
    
    @PostMapping 
    public Course save(@RequestBody Course course) throws Exception{
        return service.save(course);
    }
    
    @PutMapping("/{id}") 
    public Course update(@RequestBody Course course, @PathVariable("id") Integer id) throws Exception{
        return service.update(course, id);
    }
    
    @DeleteMapping("/{id}") 
    public void delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
    }
}