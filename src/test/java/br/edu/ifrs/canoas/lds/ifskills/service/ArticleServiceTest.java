/*
 * 
 */
package br.edu.ifrs.canoas.lds.ifskills.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.edu.ifrs.canoas.lds.ifskills.IFSkillsApplication;
import br.edu.ifrs.canoas.lds.ifskills.domain.Article;
import br.edu.ifrs.canoas.lds.ifskills.repository.UserRepository;

// TODO: Auto-generated Javadoc
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(IFSkillsApplication.class)
public class ArticleServiceTest {

	@Autowired
	ArticleService articleService;
	@Autowired
	UserRepository userRepository;

	/**
	 * Test to list all articles.
	 */
	@Test
	public void testToListAllArticles() {
		assertTrue(articleService.list().spliterator().estimateSize() > 0);
	}

	/**
	 * Test to get article1 and check title.
	 */
	@Test
	public void testToGetArticle1AndCheckTitle() {
		assertThat(articleService.get(1L), hasProperty("title", is("JPA, JSF e Spring Tool Boot")));
	}

	/**
	 * Test to create and save an article.
	 */
	@Test 
	public void testToCreateAndSaveAnArticle() {
		Article article = new Article();
		article.setTitle("My Title");
		article.setSlug("My Slug");
		article.setPostedOn(new Date());
		article.setAuthor(userRepository.findOne(1L));
		article.setBody("My body");
		assertThat(articleService.save(article), hasProperty("id",is(not(empty()))));
	}

	/**
	 * Test to find article2 delete it and check again.
	 */
	@Test
	public void testToFindArticle2DeleteItAndCheckAgain() {
		assertThat(articleService.get(2L), hasProperty("title", is("Spring tool boot é o título")));
		articleService.delete(2L);
		assertThat(articleService.get(2L), is(nullValue()));
	}
	
	/**
	 * Author: Luciane
	 * Date: 30/03/2016
	 * Description: Test to find for slug article1 .
	 * 
	 * Dúvida: Está correto este teste???
	 */
	@Test
	public void testToGetSlugAndCheckTitle() {
		assertThat(articleService.get("Linguagens-JPA-JSF"), hasProperty("title", is("JPA, JSF e Spring Tool Boot")));
	}

}
