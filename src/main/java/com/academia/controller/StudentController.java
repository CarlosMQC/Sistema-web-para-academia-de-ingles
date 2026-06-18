package com.academia.backend.controller;

import com.academia.dto.StudentDTO;
import com.academia.model.Student;
import com.academia.service.IStudentService;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/students")
public class StudentController {

    private final IStudentService service;
    private final ModelMapper mapper;

    public StudentController(IStudentService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll() throws Exception {
        List<StudentDTO> list = service.findAll().stream()
                .map(s -> mapper.map(s, StudentDTO.class))
                .collect(Collectors.toList());
        
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable("id") Integer id) throws Exception {
        Student obj = service.findById(id);
        
        if (obj == null) {
            throw new RuntimeException("ID NO ENCONTRADO: " + id);
        }
        
        StudentDTO dto = mapper.map(obj, StudentDTO.class);
        
        Link selfLink = linkTo(methodOn(StudentController.class).findById(id)).withSelfRel();
        Link allLink = linkTo(methodOn(StudentController.class).findAll()).withRel("all_students");
        
        dto.add(selfLink);
        dto.add(allLink);
        
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> save(@RequestBody StudentDTO dto) throws Exception {
        Student obj = mapper.map(dto, Student.class);
        Student objSaved = service.save(obj);
        StudentDTO dtoResponse = mapper.map(objSaved, StudentDTO.class);
        
        return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@PathVariable("id") Integer id, @RequestBody StudentDTO dto) throws Exception {
        Student obj = mapper.map(dto, Student.class);
        obj.setIdStudent(id); 
        Student objUpdated = service.update(obj, id);
        StudentDTO dtoResponse = mapper.map(objUpdated, StudentDTO.class);
        
        return ResponseEntity.ok(dtoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}