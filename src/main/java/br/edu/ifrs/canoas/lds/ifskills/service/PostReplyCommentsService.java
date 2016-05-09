package br.edu.ifrs.canoas.lds.ifskills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifrs.canoas.lds.ifskills.domain.PostReplyComments;
import br.edu.ifrs.canoas.lds.ifskills.repository.PostReplyCommentsRepository;

/**
 * May/09/16 - Edward Ramos - PostService
 */
@Service
public class PostReplyCommentsService {

	/**
	 * May/09/16 - Edward Ramos 
	 */
	private PostReplyCommentsRepository postReplyCommentsRepository;

	/**
	 * May/09/16 - Edward Ramos 
	 * @param postCommentsRepository
	 */
	@Autowired
	public PostReplyCommentsService(PostReplyCommentsRepository postReplyCommentsRepository) {
		this.postReplyCommentsRepository = postReplyCommentsRepository;
	}

	/**
	 * May/09/16 - Edward Ramos  - list
	 * @return
	 */
	public Iterable<PostReplyComments> list() {
		return postReplyCommentsRepository.findAll();
	}
	
	/**
	 * May/09/16 - Edward Ramos - Get
	 * @param id
	 * @return
	 */
	public PostReplyComments get(Long id) {
		return postReplyCommentsRepository.findOne(id);
	}
	
	/**
	 * May/09/16 - Edward Ramos - Save
	 * @param postComments
	 * @return
	 */
	public PostReplyComments save(PostReplyComments postReplyComments) {
		return postReplyCommentsRepository.save(postReplyComments);
	}
	
	/**
	 * May/09/16 - Edward Ramos - Delete
	 * @param id
	 */
	public void delete(Long id) {
		postReplyCommentsRepository.delete(id);
	}

}