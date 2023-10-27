package br.com.arthurhenriqu3.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.arthurhenriqu3.model.dto.WalletDto;
import br.com.arthurhenriqu3.model.dto.mapper.WalletDTOMapper;
import br.com.arthurhenriqu3.repository.WalletRepository;
import br.com.arthurhenriqu3.service.WalletService;

@Service
public class WalletServiceImpl implements WalletService {

	@Autowired
	private WalletRepository walletRepository;

	@Autowired
	private WalletDTOMapper walletDTOMapper;

	@Override
	public WalletDto register(WalletDto walletDTO) {
		return walletDTOMapper.toDTO(walletRepository.save(walletDTOMapper.toEntity(walletDTO)));
	}

	@Override
	@Transactional(readOnly = true)
	public WalletDto findById(String id) {
		return walletDTOMapper.toDTO(walletRepository.findById(UUID.fromString(id)).orElseThrow(() -> new RuntimeException()));
	}

	@Override
	public void deleteById(String id) {
		walletRepository
				.delete(walletRepository.findById(UUID.fromString(id)).orElseThrow(() -> new RuntimeException()));
	}

	@Override
	@Transactional(readOnly = true)
	public List<WalletDto> findAll() {
		return walletRepository.findAll().stream().map(w -> walletDTOMapper.toDTO(w)).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true)
	public List<WalletDto> findAll(Pageable pageable) {
		return walletRepository.findAll(pageable).getContent().stream().map(w -> new WalletDto(w))
				.collect(Collectors.toList());
	}
}