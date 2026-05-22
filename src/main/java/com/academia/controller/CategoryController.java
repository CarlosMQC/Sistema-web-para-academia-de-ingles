package com.xplorelatam.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xplorelatam.model.Category;
import com.xplorelatam.service.ICategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
	private final ICategoryService service;
	
	@GetMapping // GET, POST, PUT, DELETE
	public List<Category> findAll() throws Exception{
		return service.findAll();
	}
	
	@GetMapping("/{id}") // GET
	public Category findById(@PathVariable("id") Integer id) throws Exception{
		return service.findById(id);
	}
	
	@PostMapping // POST
	public Category save(@RequestBody Category category) throws Exception{
		return service.save(category);
	}
	
	@PutMapping("/{id}") // PUT
	public Category update(@RequestBody Category category, @PathVariable("id") Integer id) throws Exception{
		return service.update(category, id);
	}
	
	@DeleteMapping("/{id}") // DELETE
	public void delete(@PathVariable("id") Integer id) throws Exception{
		service.delete(id);
	}
}
