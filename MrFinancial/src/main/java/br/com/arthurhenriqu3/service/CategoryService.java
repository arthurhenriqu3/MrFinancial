package br.com.arthurhenriqu3.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import br.com.arthurhenriqu3.model.Category;

public interface CategoryService {

	public Category register(Category category);

	public Category findById(String id);

	public void deleteById(String id);

	public List<Category> findAll();

	public List<Category> findAll(Sort sort);

	public List<Category> findAllByType(String type);

	public List<Category> findAllByType(String type, Sort sort);
}