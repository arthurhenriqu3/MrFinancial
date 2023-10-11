package br.com.arthurhenriqu3.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arthurhenriqu3.model.Category;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

}
