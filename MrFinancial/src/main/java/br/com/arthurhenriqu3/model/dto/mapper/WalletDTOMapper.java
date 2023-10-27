package br.com.arthurhenriqu3.model.dto.mapper;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.arthurhenriqu3.model.User;
import br.com.arthurhenriqu3.model.Wallet;
import br.com.arthurhenriqu3.model.dto.UserDto;
import br.com.arthurhenriqu3.model.dto.WalletDto;

@Component
public class WalletDTOMapper implements DTOMapper<Wallet, WalletDto> {

	@Autowired
	private UserDTOMapper userDTOMapper;

	@Override
	public WalletDto toDTO(Wallet wallet) {

		UserDto userDTO = null;

		if (!Objects.isNull(wallet.getUser())) {
			userDTO = userDTOMapper.toDTO(wallet.getUser());
		}

		return null;
		//return new WalletDTO(wallet.getId(), userDTO, wallet.getName(), wallet.getStatus(), null);
	}

	@Override
	public Wallet toEntity(WalletDto walletDto) {

		User user = null;
		
		return null;

//		if (!Objects.isNull(walletDto.userDTO())) {
//			user = userDTOMapper.toEntity(walletDto.userDTO());
//		}
//
//		return new Wallet(walletDto.id(), user, walletDto.name(), walletDto.status(), null);
	}
}