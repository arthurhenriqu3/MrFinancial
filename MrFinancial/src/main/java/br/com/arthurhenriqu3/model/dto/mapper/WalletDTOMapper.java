package br.com.arthurhenriqu3.model.dto.mapper;

import org.springframework.stereotype.Component;

import br.com.arthurhenriqu3.model.Wallet;
import br.com.arthurhenriqu3.model.dto.WalletDTO;

@Component
public class WalletDTOMapper implements DTOMapper<Wallet, WalletDTO> {

	@Override
	public WalletDTO toDTO(Wallet wallet) {
		return new WalletDTO(wallet.getUser(), wallet.getName(), wallet.getStatus(), wallet.getBookEntries());
	}

	@Override
	public Wallet toEntity(WalletDTO walletDto) {
		return new Wallet(walletDto.user(), walletDto.name(), walletDto.status(), walletDto.bookEntries());
	}
}