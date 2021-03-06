package br.edu.ifrs.canoas.lds.ifskills.service;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.ifskills.domain.Comment;
import br.edu.ifrs.canoas.lds.ifskills.domain.Post;
import br.edu.ifrs.canoas.lds.ifskills.domain.Rank;
import br.edu.ifrs.canoas.lds.ifskills.repository.CommentRepository;
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
	
	private CommentRepository commentRepo;
	
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
	public PostService(PostRepository posRepo, UserRepository userRepository, DocumentService docService, RankRepository rankRepository, CommentRepository commentRepo) {
		this.postRepository = posRepo;
		this.userRepository = userRepository;
		this.docService = docService;
		this.rankRepository = rankRepository;
		this.commentRepo = commentRepo;
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
	public Post get(Long id) {
		Post p = postRepository.findOne(id);
		docService.updateRank(p);
		return p;
	}
	
	public Object listIsPublic() {
		return postRepository.findByIsPublic(true);
	}
	
	
	/**
	 * 01/05/16 - Ricardo - Save
	 * Modified by: felipe set a new rank for created posts
	 * @param post
	 * @return
	 * 
	 */
	public Post save(Post post) {
		Post savedPost = postRepository.save(post);
		//Adicionado para salvar o rank
		Rank rank = new Rank();
		rank.setDocument(savedPost);
		rank.setValue((float) 0.0);
		rankRepository.save(rank);
		savedPost.setRank(rank);
		return postRepository.save(savedPost);

	}
	
	/**
	 * 01/05/16 - Ricardo - Delete
	 * @param id
	 * 
	 * Modified by Luciane
	 * @date:18/05/2016
	 * @description: Alterations for delete Comments and Rank 
	 */
	public void delete(Long id) {
		Post post = postRepository.findOne(id);
		
		Rank rank = post.getRank();
		if (rank != null)
			rankRepository.delete(rank);
		
		List <Comment> comments = post.getComments();
		
		for (Comment comment : comments) {
			commentRepo.delete(comment);
		}
		postRepository.delete(post.getId());
	}
	/**
	 * @author Felipe
	 * @param post
	 * @return average value of rank
	 * @description: Method to get the average value of rank for post
	 */
	public Float getRank(Post post) {
		int rank = 0;
		Iterable<Rank> ranks = rankRepository.findAll();
		for (Rank r : ranks) {
			if(r.getDocument() instanceof Post){
				rank+=r.getValue();
			}
		}
		float result = post.getRank().getValue()/rank;
		DecimalFormat df = new DecimalFormat("##.##");
		df.format(result);
		return result;
	}

}