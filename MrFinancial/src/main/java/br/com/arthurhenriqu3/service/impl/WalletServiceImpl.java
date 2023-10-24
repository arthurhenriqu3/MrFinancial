package br.com.arthurhenriqu3.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.arthurhenriqu3.model.Wallet;
import br.com.arthurhenriqu3.repository.WalletRepository;
import br.com.arthurhenriqu3.service.WalletService;

@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	private WalletRepository walletRepository;

	@Override
	public Wallet register(Wallet wallet) {
		return walletRepository.save(wallet);
	}

	@Override
	public Wallet findById(String id) {
		return walletRepository.findById(UUID.fromString(id)).get();
	}

	@Override
	public void deleteById(String id) {
		walletRepository.deleteById(UUID.fromString(id));
	}

	@Override
	public List<Wallet> findAll() {
		return walletRepository.findAll();
	}

	@Override
	public List<Wallet> findAll(Sort sort) {
		return walletRepository.findAll(sort);
	}
}