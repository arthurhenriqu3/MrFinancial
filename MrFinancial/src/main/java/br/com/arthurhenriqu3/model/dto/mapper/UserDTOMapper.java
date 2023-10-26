package br.com.arthurhenriqu3.model.dto.mapper;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.arthurhenriqu3.model.User;
import br.com.arthurhenriqu3.model.dto.UserDTO;
import br.com.arthurhenriqu3.model.dto.WalletDTO;

@Component
public class UserDTOMapper implements DTOMapper<User, UserDTO> {

	@Autowired
	private WalletDTOMapper walletDTOMapper;

	@Override
	public UserDTO toDTO(User user) {
		return new UserDTO(user.getName(), user.getEmail(), user.getPhone(), user.getBirthDate(), user.getPassword(),
				user.getStatus(),
				new ArrayList<WalletDTO>());
	}

	@Override
	public User toEntity(UserDTO d) {
		return new User(d.name(), d.email(), d.phone(), d.birthDate(), d.password(), d.status(),
				d.wallets().stream().map(wDto -> walletDTOMapper.toEntity(wDto)).collect(Collectors.toList()));
	}
}