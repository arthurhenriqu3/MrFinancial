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
	public Category toEntity(CategoryDTO d) {
		return new Category(d.parent(), d.name(), d.description(), d.image(), d.status(), d.type(), d.children());
	}
}