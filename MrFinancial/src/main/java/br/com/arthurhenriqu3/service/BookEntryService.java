package br.com.arthurhenriqu3.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.arthurhenriqu3.model.BookEntry;
import br.com.arthurhenriqu3.repository.BookEntryRepository;

@Service
public class BookEntryService {

	@Autowired
	private BookEntryRepository bookEntryRepository;

	public BookEntry register(BookEntry bookEntry) {
		return bookEntryRepository.save(bookEntry);
	}

	public BookEntry findById(String id) {
		return bookEntryRepository.findById(UUID.fromString(id)).get();
	}

	public void deleteById(String id) {
		bookEntryRepository.deleteById(UUID.fromString(id));
	}

	public List<BookEntry> findAll() {
		return bookEntryRepository.findAll();
	}

	public List<BookEntry> findAll(Sort sort) {
		return bookEntryRepository.findAll(sort);
	}
}