/**
 * @author:
 * @date: 
 * @description: 
 */
package br.edu.ifrs.canoas.lds.ifskills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.ifskills.domain.Comment;
import br.edu.ifrs.canoas.lds.ifskills.repository.CommentRepository;

//TODO: Auto-generated Javadoc
@Service
public class CommentService {
	private CommentRepository commentRepository;
	
	/**
	 * Author: Luciane 
	 * Date: 27/03/2016
	 * Description: constructor instancies comment
	 * @param commentRepository
	 */
	@Autowired
	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}



	/**
	 * Author: Luciane 
	 * Date: 27/03/2016
	 * Description: Method save comments in DB
	 * Save.
	 *
	 * @param comment
	 *            the item
	 * @return the item
	 */
	public Comment save(Comment comment) {
		return commentRepository.save(comment);
	}


	/**
	 * Author: Luciane 
	 * Date: 28/03/2016
	 * Description: Method get id
	 * Save.
	 *
	 * @param comment
	 *            the item
	 * @return the item
	 */
	public Comment get(Long id) {
		return commentRepository.findOne(id);
	}

	/**
	 * Author: Luciane 
	 * Date: 28/03/2016
	 * Description: Method delete an comment
	 * @param comment
	 *            the item
	 * @return the item
	 */

	public void delete(Long id) {
		commentRepository.delete(id);
		
	}

}
