package br.com.arthurhenriqu3.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arthurhenriqu3.model.User;


public interface UserRepository extends JpaRepository<User, UUID> {
}
