package com.academia.controller;

import com.academia.dto.CourseDTO;
import com.academia.exception.ModelNotFoundException;
import com.academia.model.Course;
import com.academia.service.ICourseService;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/courses")
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
            throw new ModelNotFoundException("ID NO ENCONTRADO: " + id);
        }
        
        CourseDTO dto = mapper.map(obj, CourseDTO.class);
        
        EntityModel<CourseDTO> resource = EntityModel.of(dto);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).findById(id));
        resource.add(link.withSelfRel());
        
        return ResponseEntity.ok(resource);
    }
}