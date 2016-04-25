package br.edu.ifrs.canoas.lds.ifskills.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.ifskills.domain.Article;
import br.edu.ifrs.canoas.lds.ifskills.domain.ArticleRank;
import br.edu.ifrs.canoas.lds.ifskills.repository.ArticleRankRepository;

@Service
public class ArticleRankService {
	
	ArticleRankRepository rankRepository;
	
	@Autowired
	public ArticleRankService(ArticleRankRepository rankRepository) {
		this.rankRepository = rankRepository;
	}


	/**
	 * 24/04/16 - Ricardo - Method to calculate the media rank 
	 */	
	public Float getRank(Article article){
		Float rank = (float) 0.0;
		List<ArticleRank> ranks = rankRepository.findAllByArticle(article);
		
		for (ArticleRank articleRank : ranks) {
			rank += articleRank.getRank();
		}
		
		return rank/ranks.size();
	}

}
