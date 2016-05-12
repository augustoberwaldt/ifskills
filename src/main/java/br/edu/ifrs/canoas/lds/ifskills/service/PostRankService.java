package br.edu.ifrs.canoas.lds.ifskills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.ifskills.domain.Post;
import br.edu.ifrs.canoas.lds.ifskills.domain.PostRank;
import br.edu.ifrs.canoas.lds.ifskills.repository.PostRankRepository;
/**
 * 
 * @author Felipe
 * Date:11/05/2016
 * Description: increments view on postrank
 */
@Service
public class PostRankService {
	
	PostRankRepository PrRepository;
	
	/*//This method needs the superclass
	@Autowired
	@Override
	default Post findOne(long id){
		Post post = findOne(id);
		PostRank pr = PrRepository.findByPost(post);
		pr.setRank(pr.getViews() +1);
		PrRepository.save(pr);
		return post;
	}
*/
	}
