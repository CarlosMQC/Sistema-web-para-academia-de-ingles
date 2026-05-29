package com.academia.backend.controller;

import com.academia.dto.StudentDTO;
import com.academia.model.Student;
import com.academia.service.IStudentService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<EntityModel<StudentDTO>> findById(@PathVariable("id") Integer id) throws Exception {
        Student obj = service.findById(id);
        
        if (obj == null) {
            throw new RuntimeException("ID NO ENCONTRADO: " + id);
        }
        
        StudentDTO dto = mapper.map(obj, StudentDTO.class);
        
        EntityModel<StudentDTO> resource = EntityModel.of(dto);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).findById(id));
        resource.add(link.withSelfRel());
        
        return ResponseEntity.ok(resource);
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