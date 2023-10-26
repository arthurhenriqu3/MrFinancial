package br.com.arthurhenriqu3.model.dto;

import java.time.LocalDate;

import br.com.arthurhenriqu3.model.enums.StatusEnum;
import jakarta.validation.constraints.NotNull;

public record UserDTO(
		String name,
		String email,
		String phone,
		LocalDate birthDate,
		String password,
		@NotNull StatusEnum status
	) {}