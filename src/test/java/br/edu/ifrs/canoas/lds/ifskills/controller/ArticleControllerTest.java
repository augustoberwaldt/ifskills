package br.edu.ifrs.canoas.lds.ifskills.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.edu.ifrs.canoas.lds.ifskills.IFSkillsApplication;

//TODO: Auto-generated Javadoc
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(IFSkillsApplication.class)
@WebAppConfiguration
public class ArticleControllerTest extends BaseControllerTest{
	
	@Autowired 
	ArticleController articleController;
	
	@Before
	public void setup() {
		mockMvc = getMockMvc(articleController);
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
	

	

}
