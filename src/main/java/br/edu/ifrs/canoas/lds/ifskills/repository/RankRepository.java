package br.edu.ifrs.canoas.lds.ifskills.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifrs.canoas.lds.ifskills.domain.Document;
import br.edu.ifrs.canoas.lds.ifskills.domain.Rank;
/**
 * 
 * @author Felipe
 * Date: 11/05/2016
 * 
 **/

public interface RankRepository extends CrudRepository<Rank, Long> {
	
	

	//Rank findByPost(Post post);
	
	List<Rank> findAllByDocument(Document document);
}
