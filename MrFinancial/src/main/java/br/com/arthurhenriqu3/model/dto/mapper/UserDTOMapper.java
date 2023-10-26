package br.com.arthurhenriqu3.model.dto.mapper;

import org.springframework.stereotype.Component;

import br.com.arthurhenriqu3.model.User;
import br.com.arthurhenriqu3.model.dto.UserDTO;

@Component
public class UserDTOMapper implements DTOMapper<User, UserDTO> {

	@Override
	public UserDTO toDTO(User user) {
		return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPhone(), user.getBirthDate(), user.getPassword(),
				user.getStatus());
	}

	@Override
	public User toEntity(UserDTO d) {
		return new User(d.name(), d.email(), d.phone(), d.birthDate(), d.password(), d.status());
	}
}