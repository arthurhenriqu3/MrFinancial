package br.com.arthurhenriqu3.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.arthurhenriqu3.model.Category;
import br.com.arthurhenriqu3.model.enums.TypeEnum;
import br.com.arthurhenriqu3.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Category register(Category category) {
		return categoryRepository.save(category);
	}

	public Category findById(String id) {
		return categoryRepository.findById(UUID.fromString(id)).get();
	}

	public void deleteById(String id) {
		categoryRepository.deleteById(UUID.fromString(id));
	}

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public List<Category> findAll(Sort sort) {
		return categoryRepository.findAll(sort);
	}
	
	public List<Category> findAllByType(String type) {
		return categoryRepository.findByType(TypeEnum.findByCode(Byte.parseByte(type)));
	}
	
	public List<Category> findAllByType(String type, Sort sort) {
		return categoryRepository.findByType(TypeEnum.findByCode(Byte.parseByte(type)), sort);
	}
}