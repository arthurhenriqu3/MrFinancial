package br.com.arthurhenriqu3.model.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.arthurhenriqu3.model.Category;
import br.com.arthurhenriqu3.model.dto.CategoryDto;

@Component
public class CategoryDTOMapper implements DTOMapper<Category, CategoryDto> {

	@Override
	public CategoryDto toDTO(Category category) {
		return null;
//		return new CategoryDto(category.getId(), toDTO(category.getParent()), category.getName(),
//				category.getDescription(), category.getImage(), category.getStatus(), category.getType(),
//				listEntityToDTO(category.getChildren()));
	}

	@Override
	public Category toEntity(CategoryDto categoryDto) {
		return null;

//		return new Category(categoryDto.id(), toEntity(categoryDto.parent()), categoryDto.name(),
//				categoryDto.description(), categoryDto.image(), categoryDto.status(), categoryDto.type(),
//				listDTOToEntity(categoryDto.children()));
	}

	private List<CategoryDto> listEntityToDTO(List<Category> l) {
		if ((Objects.isNull(l))) {
			return new ArrayList<CategoryDto>();
		} else if (l.size() == 0) {
			return new ArrayList<CategoryDto>();
		}

		List<CategoryDto> categoriesDTO = new ArrayList<CategoryDto>();

		for (Category category : l) {
//			categoriesDTO.add(new CategoryDto(category.getId(), toDTO(category.getParent()), category.getName(),
//					category.getDescription(), category.getImage(), category.getStatus(), category.getType(),
//					((!Objects.isNull(category.getChildren())) && (category.getChildren().size() > 0))
//							? this.listEntityToDTO(category.getChildren())
//							: new ArrayList<CategoryDto>()));
		}

		return categoriesDTO;
	}

	private List<Category> listDTOToEntity(List<CategoryDto> categoriesDTO) {
		if ((Objects.isNull(categoriesDTO))) {
			return new ArrayList<Category>();
		} else if (categoriesDTO.size() == 0) {
			return new ArrayList<Category>();
		}

		List<Category> categories = new ArrayList<Category>();

		for (CategoryDto categoryDTO : categoriesDTO) {
//			categories.add(new Category(categoryDTO.id(), toEntity(categoryDTO.parent()), categoryDTO.name(),
//					categoryDTO.description(), categoryDTO.image(), categoryDTO.status(), categoryDTO.type(),
//					((!Objects.isNull(categoryDTO.children())) && (categoryDTO.children().size() > 0))
//							? this.listDTOToEntity(categoryDTO.children())
//							: new ArrayList<Category>()));
		}

		return categories;
	}
}