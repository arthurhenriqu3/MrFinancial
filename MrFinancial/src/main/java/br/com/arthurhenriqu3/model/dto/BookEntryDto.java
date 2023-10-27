package br.com.arthurhenriqu3.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import br.com.arthurhenriqu3.model.BookEntry;
import br.com.arthurhenriqu3.model.enums.StatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class BookEntryDto {
	private UUID id;
	private @NotNull CategoryDto categoryDto;
	private @NotNull WalletDto walletDto;
	private @NotBlank @NotEmpty @NotNull @Length(max = 100) String name;
	private String description;
	private @NotNull @Positive BigDecimal value;
	private @NotNull LocalDate date;
	private @NotNull StatusEnum status;

	public BookEntryDto(BookEntry bookEntry) {
		this.id = bookEntry.getId();
//		this.categoryDto = bookEntry;
		this.walletDto = new WalletDto(bookEntry.getWallet());
		this.name = bookEntry.getName();
		this.description = bookEntry.getDescription();
		this.value = bookEntry.getValue();
		this.date = bookEntry.getDate();
		this.status = bookEntry.getStatus();
	}

	public BookEntryDto(UUID id, @NotNull CategoryDto categoryDto, @NotNull WalletDto walletDto,
			@NotBlank @NotEmpty @NotNull @Length(max = 100) String name, String description,
			@NotNull @Positive BigDecimal value, @NotNull LocalDate date, @NotNull StatusEnum status) {
		super();
		this.id = id;
		this.categoryDto = categoryDto;
		this.walletDto = walletDto;
		this.name = name;
		this.description = description;
		this.value = value;
		this.date = date;
		this.status = status;
	}

	public UUID getId() {
		return id;
	}

	public CategoryDto getCategoryDto() {
		return categoryDto;
	}

	public WalletDto getWalletDto() {
		return walletDto;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getValue() {
		return value;
	}

	public LocalDate getDate() {
		return date;
	}

	public StatusEnum getStatus() {
		return status;
	}

}