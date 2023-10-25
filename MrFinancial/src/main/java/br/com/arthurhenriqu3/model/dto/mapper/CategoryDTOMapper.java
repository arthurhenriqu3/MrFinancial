package br.com.arthurhenriqu3.model.dto.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.arthurhenriqu3.model.Category;
import br.com.arthurhenriqu3.model.dto.CategoryDTO;

@Component
public class CategoryDTOMapper implements DTOMapper<Category, CategoryDTO> {

	@Override
	public CategoryDTO toDTO(Category category) {
		List<CategoryDTO> categoriesDTO = listEntityToDTO(category.getChildren());
		return new CategoryDTO(category.getParent(), category.getName(), category.getDescription(), category.getImage(),
				category.getStatus(), category.getType(), categoriesDTO);
	}

	@Override
	public Category toEntity(CategoryDTO categoryDto) {
		List<Category> categories = listDTOToEntity(categoryDto.children());

		return new Category(categoryDto.parent(), categoryDto.name(), categoryDto.description(), categoryDto.image(),
				categoryDto.status(), categoryDto.type(), categories);
	}

	private List<CategoryDTO> listEntityToDTO(List<Category> l) {
		if((Objects.isNull(l))) {
			return new ArrayList<CategoryDTO>();
		}else if(l.size() == 0) {
			return new ArrayList<CategoryDTO>();
		}
		
		List<CategoryDTO> categoriesDTO = new ArrayList<CategoryDTO>();
		
		l.forEach(System.out::println);

		for (Category category : l) {
			if((!Objects.isNull(category.getChildren())) && (category.getChildren().size()>0)) {
				this.listEntityToDTO(category.getChildren());
			}
			
			categoriesDTO.add(new CategoryDTO(category.getParent(), category.getName(), category.getDescription(), category.getImage(), category.getStatus(), category.getType(), 
					((!Objects.isNull(category.getChildren())) && (category.getChildren().size()>0)) ? new ArrayList<CategoryDTO>() : new ArrayList<CategoryDTO>()));
			
		}
			
		
		categoriesDTO.forEach(System.out::println);		
		return categoriesDTO;

	}

	private List<Category> listDTOToEntity(List<CategoryDTO> l) {
		System.out.println("Function IN");

		if ((!Objects.isNull(l)) && (true)) {
			System.out.println("Ok");
		}

		return new ArrayList<Category>();

	}

}