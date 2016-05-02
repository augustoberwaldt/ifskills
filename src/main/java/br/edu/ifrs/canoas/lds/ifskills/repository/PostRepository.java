package br.edu.ifrs.canoas.lds.ifskills.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifrs.canoas.lds.ifskills.domain.Post;

/**
 * 01/05/16 - Ricardo - PostRepository extends CrudRepository
 */
public interface PostRepository extends CrudRepository<Post, Long> {

}