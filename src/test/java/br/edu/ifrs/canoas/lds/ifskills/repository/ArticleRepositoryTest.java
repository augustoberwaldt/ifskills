/**
 * @author:
 * @date: 
 * @description: 
 */
package br.edu.ifrs.canoas.lds.ifskills.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.edu.ifrs.canoas.lds.ifskills.IFSkillsApplication;
import br.edu.ifrs.canoas.lds.ifskills.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(IFSkillsApplication.class)
public class ArticleRepositoryTest {

	@Autowired
	ArticleRepository articleRepository;
	
	@Autowired
	ArticleService articleService;
	
	/**
	 * Test to find all articles that are checked.
	 */
	@Test
	public void testToFindAllArticlesThatAreChecked() {
		assertThat(articleRepository.findChecked().size(), is(5));
	}
	
	/**
	 * @author Edward
	 * @Date:14/04/2016
	 * @Description: Test to find by slug article.
	 * 
	 */
	@Test
	public void testToFindOnePublicArticle() {
		assertThat(articleRepository.findByPrivateArticle(false).size(), is(1));
	}
	
	
	/**
	 * @author Luciane
	 * @Date:30/03/2016
	 * @Description: Test to find by slug article.
	 * 
	 * Change: 23/04/2016 - Ricardo - Change test for article id 1
	 */
	@Test
	public void testToFindBySlugArticleAndCheckPropertyUserId(){
		assertThat(articleRepository.findBySlug("get-with-the-program"), hasProperty("title", is("Get With the Program")));
		
	}
}
