package com.xplorelatam.service;

import java.util.List;

import com.xplorelatam.model.Category;

public interface ICategoryService {
	Category save(Category category) throws Exception;
	Category update(Category category, Integer id) throws Exception;
	List<Category> findAll() throws Exception;
	Category findById(Integer id) throws Exception;
	void delete(Integer id) throws Exception;
	//List<Category> findTopTen() throws Exception;
}
