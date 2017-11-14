package controllers;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import models.Photo;;

// This will be AUTO IMPLEMENTED by Spring into a Bean called bathroomRepository
// CRUD refers Create, Read, Update, Delete

public interface PhotoRepository extends CrudRepository<Photo, Long> {
	Iterable<Photo> findByBathroomId(Integer bathroomId);
}
