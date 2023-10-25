package br.com.arthurhenriqu3.model.dto.mapper;

import br.com.arthurhenriqu3.model.User;
import br.com.arthurhenriqu3.model.dto.UserDTO;

public class UserDTOMapper implements DTOMapper<User, UserDTO> {

	@Override
	public UserDTO toDTO(User user) {
		return new UserDTO(user.getName(), user.getEmail(), user.getPhone(), user.getBirthDate(), user.getPassword(),
				user.getStatus(), user.getWallets());
	}

	@Override
	public User toEntity(UserDTO d) {
		return new User(d.name(), d.email(), d.phone(), d.birthDate(), d.password(), d.status(), d.wallets());
	}
}