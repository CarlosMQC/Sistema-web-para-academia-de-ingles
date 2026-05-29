package com.academia.controller;

import com.academia.dto.EnrollmentDTO;
import com.academia.exception.ModelNotFoundException;
import com.academia.model.Enrollment;
import com.academia.service.IEnrollmentService;
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
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final IEnrollmentService service;
    private final ModelMapper mapper;

    public EnrollmentController(IEnrollmentService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<EnrollmentDTO>> findAll() throws Exception {
        List<EnrollmentDTO> list = service.findAll().stream()
                .map(e -> mapper.map(e, EnrollmentDTO.class))
                .collect(Collectors.toList());
        
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<EnrollmentDTO>> findById(@PathVariable("id") Integer id) throws Exception {
        Enrollment obj = service.findById(id);
        
        if (obj == null) {
            throw new ModelNotFoundException("ID NO ENCONTRADO: " + id);
        }
        
        EnrollmentDTO dto = mapper.map(obj, EnrollmentDTO.class);
        
        EntityModel<EnrollmentDTO> resource = EntityModel.of(dto);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).findById(id));
        resource.add(link.withSelfRel());
        
        return ResponseEntity.ok(resource);
    }
}