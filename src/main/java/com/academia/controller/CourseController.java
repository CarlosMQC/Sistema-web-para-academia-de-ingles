package com.academia.backend.controller;

import com.academia.dto.CourseDTO;
import com.academia.model.Course;
import com.academia.service.ICourseService;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

    private final ICourseService service;
    private final ModelMapper mapper;

    public CourseController(ICourseService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> findAll() throws Exception {
        List<CourseDTO> list = service.findAll().stream()
                .map(c -> mapper.map(c, CourseDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<CourseDTO>> findById(@PathVariable("id") Integer id) throws Exception {
        Course obj = service.findById(id);
        if (obj == null) {
            throw new RuntimeException("ID NO ENCONTRADO: " + id);
        }
        CourseDTO dto = mapper.map(obj, CourseDTO.class);
        EntityModel<CourseDTO> resource = EntityModel.of(dto);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).findById(id));
        resource.add(link.withSelfRel());
        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> save(@RequestBody CourseDTO dto) throws Exception {
        Course obj = mapper.map(dto, Course.class);
        Course objSaved = service.save(obj);
        CourseDTO dtoResponse = mapper.map(objSaved, CourseDTO.class);
        return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update(@PathVariable("id") Integer id, @RequestBody CourseDTO dto) throws Exception {
        dto.setIdCourse(id);
        Course obj = mapper.map(dto, Course.class);
        Course objUpdated = service.update(obj, id);
        CourseDTO dtoResponse = mapper.map(objUpdated, CourseDTO.class);
        return ResponseEntity.ok(dtoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}