package com.xplorelatam.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(ProviderTagFK.class)
public class ProviderTag {
	@Id
	//@ManyToOne
	private Provider provider;
	
	@Id
	//@ManyToOne
	private Tag tag;
	
	/*static class ProviderTagFK implements Serializable {
		@ManyToOne
		private Provider provider;
		
		@ManyToOne
		private Tag tag;
	}
	*/
}
