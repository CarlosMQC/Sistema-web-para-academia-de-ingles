package com.xplorelatam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xplorelatam.model.Category;
import com.xplorelatam.repository.ICategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
	private final ICategoryRepository repo;
	
	@Override
	public Category save(Category category) throws Exception {
		return repo.save(category);
	}

	@Override
	public Category update(Category category, Integer id) throws Exception {
		// TODO Logica utilizando ID
		category.setIdCategory(id);
		return repo.save(category);
	}

	@Override
	public List<Category> findAll() throws Exception {
		return repo.findAll();
	}

	@Override
	public Category findById(Integer id) throws Exception {
		return repo.findById(id).orElse(new Category());
	}

	@Override
	public void delete(Integer id) throws Exception {
		repo.deleteById(id);	
	}

}
