/**
 * @author:
 * @date: 
 * @description: 
 */
package br.edu.ifrs.canoas.lds.ifskills.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.ifskills.domain.Article;
import br.edu.ifrs.canoas.lds.ifskills.repository.ArticleRepository;

// TODO: Auto-generated Javadoc
@Service
public class ArticleService {

	private ArticleRepository articleRepository;

	/**
	 * Instantiates a new article service.
	 *
	 * @param artRepo
	 *            the art repo
	 */
	@Autowired
	public ArticleService(ArticleRepository artRepo) {
		this.articleRepository = artRepo;
	}

	/**
	 * List.
	 *
	 * @return the iterable
	 */
	public Iterable<Article> list() {
		return articleRepository.findAll();
	}

	/**
	 * Gets the.
	 *
	 * @param id
	 *            the id
	 * @return the article
	 */
	public Article get(Long id) {
		return articleRepository.findOne(id);
	}

	/**
	 * Save.
	 *
	 * @param articles
	 *            the articles
	 * @return the article
	 */
	public Article save(Article articles) {
		return articleRepository.save(articles);
	}

	/**
	 * Delete.
	 *
	 * @param id
	 *            the id
	 */
	public void delete(Long id) {
		articleRepository.delete(id);
	}

	/**
	 * Author: Luciane
	 * Data: 25/03/2016
	 * Description: Returns the list of existing articles in database
	 * Find all.
	 *
	 * @return the iterable
	 */
	public Iterable<Article> findAll() {
		// return articleRepository.findAll(new PageRequest(1, 20));
		return articleRepository.findAll();
	}
	
	/**
	 * Author: Luciane
	 * Data: 25/03/2016
	 * Description: capture the slug Article
	 * 
	 * view.
	 *
	 * @param id
	 *            the id
	 */
	public Article get(String slug) {
		return articleRepository.findBySlug(slug);
	}
	
	/**
	 * 01/04/16 - Ricardo - List titles
	 * @param parameter
	 * @return
	 */
	public List<Article> list(String parameter) {
		return articleRepository.findAllByTitleContainingAllIgnoreCase(parameter);
	}	
	
}