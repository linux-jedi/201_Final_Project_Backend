package controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findById(long id);
	
	Collection<User> findByUsernameAndPassword(String username, String password);
	
	Optional<User> findByUsername(String username);
}
