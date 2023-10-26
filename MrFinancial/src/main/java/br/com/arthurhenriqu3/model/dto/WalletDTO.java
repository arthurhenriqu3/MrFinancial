package br.com.arthurhenriqu3.model.dto;

import java.util.List;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import br.com.arthurhenriqu3.model.enums.StatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record WalletDTO(
		UUID id,
		@NotNull UserDTO userDTO,
		@NotBlank @NotEmpty @NotNull @Length(max = 100) String name,
		@NotNull StatusEnum status,
		List<BookEntryDTO> bookEntryDTO
	){
	
}