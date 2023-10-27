package br.com.arthurhenriqu3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import br.com.arthurhenriqu3.model.enums.StatusEnum;
import br.com.arthurhenriqu3.model.enums.converter.StatusConverter;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_wallet")
public class Wallet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@ManyToOne
	@JsonProperty(access = Access.WRITE_ONLY)
	@JoinColumn(name = "user_id")
	private User user;

	@NotBlank
	@NotEmpty
	@NotNull
	@Length(max = 100)
	@Column(nullable = false)
	private String name;

	@NotNull
	@Column(nullable = false)
	@Convert(converter = StatusConverter.class)
	private StatusEnum status;

	@JsonProperty(access = Access.WRITE_ONLY)
	@OneToMany(mappedBy = "wallet", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BookEntry> bookEntries;

	public Wallet() {
		this.bookEntries = new ArrayList<BookEntry>();
		this.status = StatusEnum.INATIVO;
	}

	public Wallet(UUID id, User user, String name, StatusEnum status, List<BookEntry> bookEntries) {
		super();
		this.id = id;
		this.user = user;
		this.name = name;
		this.status = status;
		this.bookEntries = bookEntries;
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

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public List<BookEntry> getBookEntries() {
		return bookEntries;
	}

	public void setBookEntries(List<BookEntry> bookEntries) {
		this.bookEntries = bookEntries;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		Wallet other = (Wallet) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Wallet [id=" + id + ", name=" + name + ", user=[" + user + "]]";
	}
}