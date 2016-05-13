package br.edu.ifrs.canoas.lds.ifskills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.ifskills.domain.Item;
import br.edu.ifrs.canoas.lds.ifskills.domain.Post;
import br.edu.ifrs.canoas.lds.ifskills.domain.Rank;
import br.edu.ifrs.canoas.lds.ifskills.repository.PostRepository;
import br.edu.ifrs.canoas.lds.ifskills.repository.RankRepository;
import br.edu.ifrs.canoas.lds.ifskills.repository.UserRepository;

/**
 * 01/05/16 - Ricardo - PostService
 */
@Service
public class PostService {
	

	/**
	 * 01/05/16 - Ricardo
	 */
	private PostRepository postRepository;
	
	private RankRepository rankRepository;
	
	/**
	 * @author Luciane
	 * @date: 11/05/2016
	 * @description: Add userRepository
	 */
	@SuppressWarnings("unused")
	private UserRepository userRepository;
	
	/**
	 * @author Felipe
	 * @date: 12/05/2016
	 * @description: Add documentService
	 */
	private DocumentService docService;

	/**
	 * 01/05/16 - Ricardo
	 * @param posRepo
	 */
	@Autowired
	public PostService(PostRepository posRepo, UserRepository userRepository, DocumentService docService, RankRepository rankRepository) {
		this.postRepository = posRepo;
		this.userRepository = userRepository;
		this.docService = docService;
		this.rankRepository = rankRepository;
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
	 * Modified by: Felipe
	 * Description: docService intercept post to update rank
	 */
	public Post getRank(Long id) {
		Post p = postRepository.findOne(id);
		docService = new DocumentService();
		docService.updateRank(p);
		return p;
	}
	
	/**
	 * Gets the.
	 *
	 * @param id
	 *            the id
	 * @return the item
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
	/**
	 * @author Felipe
	 * @param post
	 * @return average value of rank
	 * @description: Method to get the average value of rank for post
	 */
	public Integer getRank(Post post) {
		int rank = 0;
		Iterable<Rank> ranks = rankRepository.findAll();
		for (Rank r : ranks) {
			if(r.getDocument() instanceof Post){
				rank+=r.getRank();
			}
		}
		return post.getRank().getRank()/rank;
	}

}