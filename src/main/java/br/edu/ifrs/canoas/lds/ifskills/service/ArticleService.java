package br.edu.ifrs.canoas.lds.ifskills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.ifskills.domain.Article;
import br.edu.ifrs.canoas.lds.ifskills.repository.ArticleRepository;

@Service
public class ArticleService {

	private ArticleRepository articleRepository;
	
	@Autowired
	public ArticleService(ArticleRepository artRepo) {
		this.articleRepository = artRepo;
	}
	
	public Iterable<Article> list() {
		return articleRepository.findAll();
	}

	public Article get(Long id) {
		return articleRepository.findOne(id);
	}

	public Article save(Article articles) {
		return articleRepository.save(articles);
	}

	public void delete(Long id) {
		articleRepository.delete(id);
	}


	public Iterable<Article> findAll() {
	    return articleRepository.findAll(new PageRequest(1, 20));
	  }
}