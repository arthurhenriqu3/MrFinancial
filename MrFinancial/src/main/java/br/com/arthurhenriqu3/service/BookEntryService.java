package br.com.arthurhenriqu3.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import br.com.arthurhenriqu3.model.BookEntry;

public interface BookEntryService {
	
	public BookEntry register(BookEntry bookEntry);

	public BookEntry findById(String id);

	public void deleteById(String id);

	public List<BookEntry> findAll();

	public List<BookEntry> findAll(Sort sort);
	
}
