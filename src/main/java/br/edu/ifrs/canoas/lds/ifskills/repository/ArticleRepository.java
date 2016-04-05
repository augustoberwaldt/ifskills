/*
 * 
 */
package br.edu.ifrs.canoas.lds.ifskills.repository;

/**
 * Author: Felipe
 * Date: 28/03/2016
 * Description: Repository for the Articles
 */

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.ifrs.canoas.lds.ifskills.domain.Article;

// TODO: Auto-generated Javadoc
public interface ArticleRepository extends CrudRepository<Article, Long> {

	/**
	 * Author: Felipe
	 * Date: 03/04/2016
	 * Find checked.
	 *
	 * @return the list
	 */
	@Query("SELECT i FROM Article i WHERE i.active=true")
	List<Article> findChecked();

	/**
	 * Author: Felipe
	 * Date: 03/04/2016
	 * Find all.
	 *
	 * @param pageable
	 *            the pageable
	 * @return the list
	 */
	List<Article> findAll(Pageable pageable);
	
	/** 
	 * Author: Luciane
	 * Date: 25/03/2016
	 * Description: Method that finds the slug Article
	 * @param slug
	 * @return
	 */	
	Article findBySlug(String slug);
	
	/**
	 * 01/04/16 - Ricardo - Method to find Title
	 * @param title
	 * @return
	 */
	List<Article> findAllByTitleContainingOrBodyContainingAllIgnoreCase(String title, String body);

}
