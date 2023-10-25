package br.com.arthurhenriqu3.model.dto;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import br.com.arthurhenriqu3.model.BookEntry;
import br.com.arthurhenriqu3.model.User;
import br.com.arthurhenriqu3.model.enums.StatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record WalletDTO(
		User user,
		@NotBlank @NotEmpty @NotNull @Length(max = 100) String name,
		@NotNull StatusEnum status,
		List<BookEntry> bookEntries
	) {}