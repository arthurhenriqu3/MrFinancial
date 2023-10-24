package br.com.arthurhenriqu3.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.arthurhenriqu3.model.Category;
import br.com.arthurhenriqu3.model.enums.TypeEnum;
import br.com.arthurhenriqu3.repository.CategoryRepository;
import br.com.arthurhenriqu3.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category register(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category findById(String id) {
		return categoryRepository.findById(UUID.fromString(id)).get();
	}

	@Override
	public void deleteById(String id) {
		categoryRepository.deleteById(UUID.fromString(id));
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public List<Category> findAll(Sort sort) {
		return categoryRepository.findAll(sort);
	}
	
	@Override
	public List<Category> findAllByType(String type) {
		return categoryRepository.findByType(TypeEnum.findByCode(Byte.parseByte(type)));
	}
	
	@Override
	public List<Category> findAllByType(String type, Sort sort) {
		return categoryRepository.findByType(TypeEnum.findByCode(Byte.parseByte(type)), sort);
	}
}