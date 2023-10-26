package br.com.arthurhenriqu3.model.dto.mapper;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.arthurhenriqu3.model.Wallet;
import br.com.arthurhenriqu3.model.dto.UserDTO;
import br.com.arthurhenriqu3.model.dto.WalletDTO;

@Component
public class WalletDTOMapper implements DTOMapper<Wallet, WalletDTO> {

	@Autowired
	private UserDTOMapper userDTOMapper;

	@Override
	public WalletDTO toDTO(Wallet wallet) {

		UserDTO userDTO = null;

		if (!Objects.isNull(wallet.getUser())) {
			userDTO = userDTOMapper.toDTO(wallet.getUser());
		}

		return new WalletDTO(wallet.getId(), userDTO, wallet.getName(), wallet.getStatus(), null);
	}

	@Override
	public Wallet toEntity(WalletDTO walletDto) {
		return new Wallet(walletDto.id(), walletDto.name(), walletDto.status(), null);
	}
}