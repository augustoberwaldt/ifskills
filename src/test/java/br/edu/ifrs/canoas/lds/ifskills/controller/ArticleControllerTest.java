package br.edu.ifrs.canoas.lds.ifskills.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.edu.ifrs.canoas.lds.ifskills.IFSkillsApplication;
import br.edu.ifrs.canoas.lds.ifskills.service.ArticleService;

//TODO: Auto-generated Javadoc
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(IFSkillsApplication.class)
@WebAppConfiguration
public class ArticleControllerTest extends BaseControllerTest{
	
	@Autowired 
	ArticleController articleController;
	
	@Autowired
    private ArticleService articleService;
	
	@Before
	public void setup() {
		mockMvc = getMockMvc(articleController);
	}

	/**
	 * Author: Felipe 
	 * Date:06/04/2016
	 * Test to create a new article and check atts.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testToCreateNewArticleAndCheckAtts() throws Exception {
		this.mockMvc.perform(post("/article/new"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("article"))
			.andExpect(model().attribute("article", hasProperty("title", isEmptyOrNullString())))
			.andExpect(model().attribute("readonly",is(false)))
			.andExpect(forwardedUrl(PRE_URL+"/article/new"+POS_URL))
			;
	}
	
	/**
	 * @author Luciane
	 * @Date: 30/03/2016
	 * Description:
	 * Test to view Article1 for Slug and check atts.
	 * @throws Exception the exception
	 */
	@Test
	public void testToViewSlugArticle1AndCheckAtts() throws Exception {
		this.mockMvc.perform(post("/article/view/Linguagens-JPA-JSF"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("article"))
			.andExpect(model().attribute("article", hasProperty("title", is("JPA, JSF e Spring Tool Boot"))))
			.andExpect(forwardedUrl(PRE_URL+"/article/view"+POS_URL))
			;
	}
	
	
	/**
	 * @author Aline G.
	 * @Date: 05/04/2016
	 * Description:
	 * Test to check Article3, delete it and check again.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testToCheckArticle3DeleteItAndCheckAgain() throws Exception {
		
		assertThat(articleService.get(3L), is(notNullValue()));
		assertThat(articleService.get(3L).getTitle(), is("A educação em último lugar no país"));
		
		this.mockMvc.perform(post("/article/delete/3"))
			.andExpect(flash().attributeExists("message"))
			;
		
		assertThat(articleService.get(3L), is(nullValue()));

	}

	/**
	 * @author Aline G.
	 * @Date: 05/04/2016
	 * Description:
	 * Test to delete Article1000 that does not exists.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testToDeleteArticle1000ThatDoesNotExists() throws Exception {
		
		assertThat(articleService.get(1000L), is(nullValue()));
		
		this.mockMvc.perform(post("/article/delete/1000"))
		.andExpect(view().name("/"))
		.andExpect(status().isOk())
		//.andExpect(model().attribute("message", containsString("failed to delete")))
		;

	}

}
