package br.edu.ifrs.canoas.lds.ifskills.controller;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import br.edu.ifrs.canoas.lds.ifskills.IFSkillsApplication;
import br.edu.ifrs.canoas.lds.ifskills.domain.Rank;
import br.edu.ifrs.canoas.lds.ifskills.service.PostService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(IFSkillsApplication.class)
public class PostControllerTest extends BaseControllerTest{
	
	@Autowired 
	private PostController postController;
	
	@Autowired
    private PostService postService;
	
	
	@Before
	public void setup() {
		mockMvc = getMockMvc(postController);
	}

	@Test
	public void testFindResponsibles() {
		//postController.findResponsibles(null, null);
		
	}
	
	/**
	 * @author Luciane
	 * @Date: 13/05/2016
	 * Description: Test to create a new post.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	@WithUserDetails("admin@123.123")
	public void testToCreateANewPostAndCheckAtts() throws Exception {
		this.mockMvc.perform(post("/post/create"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("post"))
			.andExpect(model().attribute("post", hasProperty("body", isEmptyOrNullString())))
			.andExpect(model().attribute("readonly",is(false)))
			.andExpect(forwardedUrl(PRE_URL+"/post/form"+POS_URL))
			;
	}
	
	/**
	 * @author Luciane
	 * @Date: 13/05/2016
	 * Description: Test to check Post 1, delete it and check again.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	@WithUserDetails("admin@123.123")
	public void testToCheckPost1DeleteItAndCheckAgain() throws Exception {
		
		/*assertThat(postService.get(1L), is(notNullValue()));
		assertThat(postService.get(1L).getTitle(), is("Welcome to IFSkills"));
		
		this.mockMvc.perform(post("/post/delete/1"))
			.andExpect(flash().attributeExists("message"))
			;
		
		assertThat(postService.get(1L), is(nullValue()));*/

	}
	
	/**
	 * @author Luciane
	 * @Date: 14/05/2016
	 * Description: Test to delete Post 1000 that does not exists.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	@WithUserDetails("admin@123.123")
	public void testToDeletePost1000ThatDoesNotExists() throws Exception {
		
		assertThat(postService.get(1000L), is(nullValue()));
		
		this.mockMvc.perform(post("/post/delete/1000"))
		.andExpect(view().name("redirect:/post/list"))
		.andExpect(flash().attributeExists("message"))
		;

	}
	
	/**
	 * @author Luciane
	 * @Date: 14/05/2016
	 * Description: Test to view Post 1 and check atts.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testToViewPost1AndCheckAtts() throws Exception {
		/*this.mockMvc.perform(post("post/view/1"))
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("post"))
		.andExpect(model().attribute("post", hasProperty("title", is("Welcome to IFSkills"))))
		.andExpect(model().attribute("readonly",is(true)))
		.andExpect(forwardedUrl(PRE_URL+"/post/form"+POS_URL))
		;*/
	}
	
	/**
	 * @author Luciane
	 * @Date: 14/05/2016
	 * Description: Test to view post with id invalid =100.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testToViewPost100ThatDoesNotExists() throws Exception {
		assertThat(postService.get(100L), is(nullValue()));
		
		this.mockMvc.perform(post("/post/view/100"))
		.andExpect(view().name("redirect:/post/list"))
		.andExpect(status().is3xxRedirection())
		.andExpect(flash().attributeExists("message"))
		;		
	}
}
