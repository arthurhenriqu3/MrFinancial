package br.com.arthurhenriqu3.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import br.com.arthurhenriqu3.model.Wallet;

public interface WalletService {

	public Wallet register(Wallet wallet);

	public Wallet findById(String id);

	public void deleteById(String id);

	public List<Wallet> findAll();

	public List<Wallet> findAll(Sort sort);
}