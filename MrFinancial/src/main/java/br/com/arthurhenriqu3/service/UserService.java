package br.com.arthurhenriqu3.service;

import java.util.List;

import br.com.arthurhenriqu3.model.User;

public interface UserService {

	public User register(User user);

	public User findById(String id);

	public void deleteById(String id);

	public List<User> findAll();
}