package br.com.arthurhenriqu3.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.arthurhenriqu3.model.Wallet;
import br.com.arthurhenriqu3.repository.WalletRepository;

@Service
public class WalletService {

	@Autowired
	private WalletRepository walletRepository;

	public Wallet register(Wallet wallet) {
		return walletRepository.save(wallet);
	}

	public Wallet findById(String id) {
		return walletRepository.findById(UUID.fromString(id)).get();
	}

	public void deleteById(String id) {
		walletRepository.deleteById(UUID.fromString(id));
	}

	public List<Wallet> findAll() {
		return walletRepository.findAll();
	}

	public List<Wallet> findAll(Sort sort) {
		return walletRepository.findAll(sort);
	}
}