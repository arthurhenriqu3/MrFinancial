package br.com.arthurhenriqu3.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import br.com.arthurhenriqu3.model.Wallet;
import br.com.arthurhenriqu3.model.dto.WalletDTO;

public interface WalletService {

	public WalletDTO register(WalletDTO walletDTO);

	public Wallet findById(String id);

	public void deleteById(String id);

	public List<WalletDTO> findAll();

	public List<WalletDTO> findAll(Pageable pageable);
}