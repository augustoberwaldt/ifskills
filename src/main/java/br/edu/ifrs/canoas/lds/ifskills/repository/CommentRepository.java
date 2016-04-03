/*
 * 
 */
package br.edu.ifrs.canoas.lds.ifskills.repository;

import java.util.List;

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
	
	
	/** 
	 * Author: Luciane
	 * Date: 03/04/2016
	 * Description: Method that returns a list of database Comments
	 * 
	 * Note: Designed to meet the unit test! That's right ???
	 */	
	List <Comment> findAll();


}
