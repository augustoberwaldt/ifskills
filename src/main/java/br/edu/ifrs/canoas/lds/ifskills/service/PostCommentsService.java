package br.edu.ifrs.canoas.lds.ifskills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifrs.canoas.lds.ifskills.domain.PostComments;
import br.edu.ifrs.canoas.lds.ifskills.repository.PostCommentsRepository;

/**
 * May/09/16 - Edward Ramos - PostService
 */
@Service
public class PostCommentsService {

	/**
	 * May/09/16 - Edward Ramos 
	 */
	private PostCommentsRepository postCommentsRepository;

	/**
	 * May/09/16 - Edward Ramos 
	 * @param postCommentsRepository
	 */
	@Autowired
	public PostCommentsService(PostCommentsRepository postCommentsRepository) {
		this.postCommentsRepository = postCommentsRepository;
	}

	/**
	 * May/09/16 - Edward Ramos  - list
	 * @return
	 */
	public Iterable<PostComments> list() {
		return postCommentsRepository.findAll();
	}
	
	/**
	 * May/09/16 - Edward Ramos - Get
	 * @param id
	 * @return
	 */
	public PostComments get(Long id) {
		return postCommentsRepository.findOne(id);
	}
	
	/**
	 * May/09/16 - Edward Ramos - Save
	 * @param postComments
	 * @return
	 */
	public PostComments save(PostComments postComments) {
		return postCommentsRepository.save(postComments);
	}
	
	/**
	 * May/09/16 - Edward Ramos - Delete
	 * @param id
	 */
	public void delete(Long id) {
		postCommentsRepository.delete(id);
	}

}