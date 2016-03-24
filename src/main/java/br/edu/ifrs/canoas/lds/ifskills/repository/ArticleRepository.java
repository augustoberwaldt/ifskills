/*
 * 
 */
package br.edu.ifrs.canoas.lds.ifskills.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.ifrs.canoas.lds.ifskills.domain.Article;

// TODO: Auto-generated Javadoc
public interface ArticleRepository extends CrudRepository<Article, Long>{
	
	/**
	 * Find checked.
	 *
	 * @return the list
	 */
	@Query("SELECT i FROM Article i WHERE i.active=true")
	List<Article> findChecked();
	
	/**
	 * Find all.
	 *
	 * @param pageable
	 *            the pageable
	 * @return the list
	 */
	List<Article> findAll(Pageable pageable);


}

