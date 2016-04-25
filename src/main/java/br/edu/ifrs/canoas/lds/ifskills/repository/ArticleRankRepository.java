package br.edu.ifrs.canoas.lds.ifskills.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifrs.canoas.lds.ifskills.domain.Article;
import br.edu.ifrs.canoas.lds.ifskills.domain.ArticleRank;

public interface ArticleRankRepository extends CrudRepository<ArticleRank, Long>{

	/**
	 * 24/04/16 - Ricardo - Method to find all article to calculate rank
	 */
	public List<ArticleRank> findAllByArticle(Article article);
	
}
