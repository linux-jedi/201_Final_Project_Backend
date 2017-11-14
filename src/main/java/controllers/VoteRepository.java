package controllers;

import org.springframework.data.repository.CrudRepository;

import models.Vote;

public interface VoteRepository extends CrudRepository<Vote, Long> {
	Iterable<Vote> getByBathroomId(Integer bathroomId	);
}
