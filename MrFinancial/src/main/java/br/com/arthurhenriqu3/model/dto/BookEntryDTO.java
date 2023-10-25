package br.com.arthurhenriqu3.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import br.com.arthurhenriqu3.model.enums.StatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record BookEntryDTO(
		@NotNull CategoryDTO categoryDto,
		@NotNull WalletDTO walletDto,
		@NotBlank @NotEmpty @NotNull @Length(max = 100) String name,
		String description,
		@NotNull @Positive BigDecimal value,
		@NotNull LocalDate date,
		@NotNull StatusEnum status
	) {}