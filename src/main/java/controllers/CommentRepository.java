package controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import models.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {
	Collection<Comment> findByBathroomId(Integer bathroomId);
	
	Optional<Comment> findById(Integer id);
}
