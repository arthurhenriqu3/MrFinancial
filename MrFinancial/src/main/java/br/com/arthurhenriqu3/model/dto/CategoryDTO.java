package br.com.arthurhenriqu3.model.dto;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import br.com.arthurhenriqu3.model.Category;
import br.com.arthurhenriqu3.model.enums.StatusEnum;
import br.com.arthurhenriqu3.model.enums.TypeEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CategoryDTO(
		Category parent,
		@NotBlank @NotEmpty @NotNull @Length(max = 50) String name, 
		String description, 
		String image, 
		@NotNull StatusEnum status,
		@NotNull TypeEnum type,
		List<Category> children
		
		)
{}
