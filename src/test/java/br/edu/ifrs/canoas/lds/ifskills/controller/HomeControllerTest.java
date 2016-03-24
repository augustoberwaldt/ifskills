package br.edu.ifrs.canoas.lds.ifskills.controller;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(IFSkillsApplication.class)
@WebAppConfiguration
public class HomeControllerTest extends BaseControllerTest{
	
	@Autowired 
	HomeController homeController;
	
	@Before
	public void setup() {
		mockMvc = getMockMvc(homeController);
	}
	
	/** Author:Luciane
	 *  Date: 24/03/2016
	 *  Description: teste do método view que 
	 *  mostra uma lista com 3 artigos na página index.html
	 * */
			
	@Test
	public void testToViewArticles() throws Exception {
		this.mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(model().attribute("articles", hasSize(3)))
			.andExpect(model().attribute("articles", hasItem(
		            allOf(
		                    hasProperty("title", is("JPA, JSF e Spring Tool Boot")),
		                    hasProperty("teaser", is("hhhhh"))
		            )
		    )))
			.andExpect(forwardedUrl(PRE_URL+"/index"+POS_URL))
			;
	}

}
