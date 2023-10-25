package br.com.arthurhenriqu3.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import br.com.arthurhenriqu3.model.enums.StatusEnum;
import br.com.arthurhenriqu3.model.enums.converter.StatusConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "tb_book_entry")
public class BookEntry implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	@JsonProperty(access = Access.WRITE_ONLY)
	@NotNull
	@ManyToOne
	@JoinColumn(name = "wallet_id", nullable = false)
	private Wallet wallet;

	@NotBlank
	@NotEmpty
	@NotNull
	@Length(max = 100)
	@Column(nullable = false)
	private String name;

	@Column(columnDefinition = "TEXT")
	private String description;

	@NotNull
	@Positive
	@Column(nullable = false)
	private BigDecimal value;

	@NotNull
	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	@Column(nullable = false)
	@Convert(converter = StatusConverter.class)
	private StatusEnum status;

	public BookEntry() {
		this.value = new BigDecimal(0);
		this.status = StatusEnum.INATIVO;
	}

	public BookEntry(@NotNull Category category, @NotNull Wallet wallet, @NotNull @Length(max = 100) String name,
			String description, @NotNull @Positive BigDecimal value, @NotNull LocalDate date, StatusEnum status) {
		super();
		this.category = category;
		this.wallet = wallet;
		this.name = name;
		this.description = description;
		this.value = value;
		this.date = date;
		this.status = status;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum statusEnum) {
		this.status = statusEnum;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookEntry other = (BookEntry) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return new StringBuilder().append(String.format("%s [%s, %s, %f]", this.getClass(), this.getId().toString(),
				this.getName(), this.getValue())).toString();
	}
}