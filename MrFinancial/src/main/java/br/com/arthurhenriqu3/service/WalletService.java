package br.com.arthurhenriqu3.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import br.com.arthurhenriqu3.model.dto.WalletDto;

public interface WalletService {

	public WalletDto register(WalletDto walletDTO);

	public WalletDto findById(String id);

	public void deleteById(String id);

	public List<WalletDto> findAll();

	public List<WalletDto> findAll(Pageable pageable);
}