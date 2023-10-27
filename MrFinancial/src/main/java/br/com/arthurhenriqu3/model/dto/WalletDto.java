package br.com.arthurhenriqu3.model.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import br.com.arthurhenriqu3.model.Wallet;
import br.com.arthurhenriqu3.model.enums.StatusEnum;
import jakarta.validation.constraints.NotBlank;

public class WalletDto {

	private UUID id;
	private UserDto userDTO;
	private @NotBlank @Length(max = 100) String name;
	private StatusEnum status;
	private List<BookEntryDto> bookEntryDTO;

	public WalletDto(UUID id, UserDto userDTO, @NotBlank @Length(max = 100) String name, StatusEnum status) {
		super();
		this.id = id;
		this.userDTO = userDTO;
		this.name = name;
		this.status = status;
		this.bookEntryDTO = new ArrayList<BookEntryDto>();
	}

	public WalletDto(Wallet wallet) {
		this.id = wallet.getId();
		this.userDTO = new UserDto(wallet.getUser());
		this.name = wallet.getName();
		this.status = wallet.getStatus();
		this.bookEntryDTO = new ArrayList<BookEntryDto>();
	}

	public UUID getId() {
		return id;
	}

	public UserDto getUserDTO() {
		return userDTO;
	}

	public String getName() {
		return name;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public List<BookEntryDto> getBookEntryDTO() {
		return bookEntryDTO;
	}
}