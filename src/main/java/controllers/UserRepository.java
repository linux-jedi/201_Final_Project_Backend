package controllers;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findById(long id);
	
	long countByUsernameAndPassword(String username, String password);
}
