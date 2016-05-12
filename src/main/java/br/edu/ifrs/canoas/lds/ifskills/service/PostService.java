package br.edu.ifrs.canoas.lds.ifskills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.ifskills.domain.Post;
import br.edu.ifrs.canoas.lds.ifskills.repository.PostRepository;

/**
 * 01/05/16 - Ricardo - PostService
 */
@Service
public class PostService {

	/**
	 * 01/05/16 - Ricardo
	 */
	private PostRepository postRepository;
	
	/**
	 * 01/05/16 - Ricardo
	 * @param posRepo
	 */
	@Autowired
	public PostService(PostRepository posRepo) {
		this.postRepository = posRepo;
	}

	/**
	 * 01/05/16 - Ricardo - list
	 * @return
	 */
	public Iterable<Post> list() {
		return postRepository.findAll();
	}
	
	/**
	 * 01/05/16 - Ricardo - Gets the
	 * @param id
	 * @return
	 */
	public Post get(Long id) {
		return postRepository.findOne(id);
	}
	
	/**
	 * 01/05/16 - Ricardo - Save
	 * @param post
	 * @return
	 */
	public Post save(Post post) {
		return postRepository.save(post);
	}
	
	/**
	 * 01/05/16 - Ricardo - Delete
	 * @param id
	 */
	public void delete(Long id) {
		postRepository.delete(id);
	}

}