package com.xplorelatam.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name="categories", schema="sales")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Integer idCategory;
	
	@Column(nullable = false, length = 70)//name="nombre")
	private String name;
	
	@Column(nullable = true, length = 200)
	private String description;
	
	@Column(nullable = false)
	private boolean status;
}
