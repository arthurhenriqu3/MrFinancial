package br.com.arthurhenriqu3.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arthurhenriqu3.model.Category;
import br.com.arthurhenriqu3.model.enums.TypeEnum;


public interface CategoryRepository extends JpaRepository<Category, UUID> {
	
	List<Category> findByType(TypeEnum type);
	List<Category> findByType(TypeEnum type, Sort sort);
	List<Category> findByOrderByNameAsc();

}
