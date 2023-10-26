package br.com.arthurhenriqu3.model.dto;

import java.time.LocalDate;
import java.util.UUID;

import br.com.arthurhenriqu3.model.enums.StatusEnum;

public record UserDTO(
		UUID id,
		String name,
		String email,
		String phone,
		LocalDate birthDate,
		String password,
		StatusEnum status
	) {}