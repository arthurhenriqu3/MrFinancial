package br.com.arthurhenriqu3.model.dto.mapper;

import org.springframework.stereotype.Component;

import br.com.arthurhenriqu3.model.User;
import br.com.arthurhenriqu3.model.dto.UserDto;

@Component
public class UserDTOMapper implements DTOMapper<User, UserDto> {

	@Override
	public UserDto toDTO(User user) {
		return null;
		//		return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getPhone(), user.getBirthDate(), user.getPassword(),
//				user.getStatus());
	}

	@Override
	public User toEntity(UserDto d) {
		return null;
		//return new User(d.name(), d.email(), d.phone(), d.birthDate(), d.password(), d.status());
	}
}