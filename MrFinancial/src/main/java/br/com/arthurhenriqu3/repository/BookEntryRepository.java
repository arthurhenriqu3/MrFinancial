package br.com.arthurhenriqu3.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arthurhenriqu3.model.BookEntry;


public interface BookEntryRepository extends JpaRepository<BookEntry, UUID> {
}
