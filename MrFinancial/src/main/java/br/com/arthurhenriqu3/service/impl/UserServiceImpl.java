package br.com.arthurhenriqu3.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.arthurhenriqu3.model.User;
import br.com.arthurhenriqu3.repository.UserRepository;
import br.com.arthurhenriqu3.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User register(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findById(String id) {
		return userRepository.findById(UUID.fromString(id)).get();
	}

	@Override
	public void deleteById(String id) {
		userRepository.deleteById(UUID.fromString(id));
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
}