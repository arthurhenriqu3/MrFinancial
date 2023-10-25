package br.com.arthurhenriqu3.model.dto.mapper;

import org.springframework.stereotype.Component;

import br.com.arthurhenriqu3.model.Category;
import br.com.arthurhenriqu3.model.dto.CategoryDTO;

@Component
public class CategoryDTOMapper implements DTOMapper<Category, CategoryDTO> {

	@Override
	public CategoryDTO toDTO(Category category) {
		return new CategoryDTO(category.getParent(), category.getName(), category.getDescription(), category.getImage(),
				category.getStatus(), category.getType(), category.getChildren());
	}

	@Override
	public Category toEntity(CategoryDTO categoryDto) {
		return new Category(categoryDto.parent(), categoryDto.name(), categoryDto.description(), categoryDto.image(),
				categoryDto.status(), categoryDto.type(), categoryDto.children());
	}
}