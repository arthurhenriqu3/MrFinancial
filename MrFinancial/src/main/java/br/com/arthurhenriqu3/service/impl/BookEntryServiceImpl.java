package br.com.arthurhenriqu3.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.arthurhenriqu3.model.BookEntry;
import br.com.arthurhenriqu3.repository.BookEntryRepository;
import br.com.arthurhenriqu3.service.BookEntryService;

@Service
public class BookEntryServiceImpl implements BookEntryService {

	@Autowired
	private BookEntryRepository bookEntryRepository;

	@Override
	public BookEntry register(BookEntry bookEntry) {
		return bookEntryRepository.save(bookEntry);
	}

	@Override
	public BookEntry findById(String id) {
		return bookEntryRepository.findById(UUID.fromString(id)).get();
	}

	@Override
	public void deleteById(String id) {
		bookEntryRepository.deleteById(UUID.fromString(id));
	}

	@Override
	public List<BookEntry> findAll() {
		return bookEntryRepository.findAll();
	}

	@Override
	public List<BookEntry> findAll(Sort sort) {
		return bookEntryRepository.findAll(sort);
	}
}