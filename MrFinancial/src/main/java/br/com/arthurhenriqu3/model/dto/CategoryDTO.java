package br.com.arthurhenriqu3.model.dto;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import br.com.arthurhenriqu3.model.Category;
import jakarta.validation.constraints.NotNull;

public record CategoryDTO(
		Category parent,
		@NotNull @Length(max = 50) String name, 
		String description, 
		String image, 
		List<Category> children
		)
{}
