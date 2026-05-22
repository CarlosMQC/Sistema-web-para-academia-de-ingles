package com.xplorelatam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xplorelatam.model.Category;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {

}
