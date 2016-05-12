package br.edu.ifrs.canoas.lds.ifskills.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifrs.canoas.lds.ifskills.domain.Post;
import br.edu.ifrs.canoas.lds.ifskills.domain.PostRank;
/**
 * 
 * @author Felipe
 * Date: 11/05/2016
 */
public interface PostRankRepository extends CrudRepository<PostRank, Long> {
	
	/**
	 * Method findOne
	 * @param id	
	 * Description: Find one by id
	 */
	PostRank findOne(Long id);

	PostRank findByPost(Post post);
}
