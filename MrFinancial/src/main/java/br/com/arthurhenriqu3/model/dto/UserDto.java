package br.com.arthurhenriqu3.model.dto;

import java.time.LocalDate;
import java.util.UUID;

import br.com.arthurhenriqu3.model.User;
import br.com.arthurhenriqu3.model.enums.StatusEnum;

public class UserDto {
	private UUID id;
	private String name;
	private String email;
	private String phone;
	private LocalDate birthDate;
	private String password;
	private StatusEnum status;

	public UserDto(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.phone = user.getPhone();
		this.birthDate = user.getBirthDate();
		this.password = user.getPassword();
		this.status = user.getStatus();
	}

	public UserDto(UUID id, String name, String email, String phone, LocalDate birthDate, String password,
			StatusEnum status) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.birthDate = birthDate;
		this.password = password;
		this.status = status;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public String getPassword() {
		return password;
	}

	public StatusEnum getStatus() {
		return status;
	}

}