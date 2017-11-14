package controllers;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import models.Bathroom;;

// This will be AUTO IMPLEMENTED by Spring into a Bean called bathroomRepository
// CRUD refers Create, Read, Update, Delete

public interface BathroomRepository extends CrudRepository<Bathroom, Long> {
	Optional<Bathroom> findById(Integer id);
}
