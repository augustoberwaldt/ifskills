/*
 * 
 */
package br.edu.ifrs.canoas.lds.ifskills.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifrs.canoas.lds.ifskills.domain.Comment;

public interface JobAdRepository extends CrudRepository<Comment, Long> {


}
