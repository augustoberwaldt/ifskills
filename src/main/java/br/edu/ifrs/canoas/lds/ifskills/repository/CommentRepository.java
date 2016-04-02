/*
 * 
 */
package br.edu.ifrs.canoas.lds.ifskills.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifrs.canoas.lds.ifskills.domain.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {
	/** 
	 * Author: Luciane
	 * Date: 30/03/2016
	 * Description:Method that seeks an article by id that is informed you
	 * @param id
	 * @return
	 */	
	Comment findOne(Long id);


}
