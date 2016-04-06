package br.edu.ifrs.canoas.lds.ifskills.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import br.edu.ifrs.canoas.lds.ifskills.IFSkillsApplication;
import br.edu.ifrs.canoas.lds.ifskills.domain.Comment;
import br.edu.ifrs.canoas.lds.ifskills.service.CommentService;

//TODO: Auto-generated Javadoc
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(IFSkillsApplication.class)
@WebAppConfiguration
public class CommentControllerTest extends BaseControllerTest{
	
	@Autowired 
	CommentController commentController;
	
	@Autowired
    private CommentService commentService;
	
	@Before
	public void setup() {
		mockMvc = getMockMvc(commentController);
	}
	

	/**
	 * @author Luciane
	 * @Date: 03/04/2016
	 * Description: Test to save a comment with valid data.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	@WithUserDetails("admin@123.123")
	public void testToSaveACommentWithValidData() throws Exception {
		
		Long size = commentService.list().spliterator().getExactSizeIfKnown();
		
		mockMvc.perform(post("/article/comment/save")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("content", "some content")
                .sessionAttr("comment", new Comment())
        )
	    .andDo(MockMvcResultHandlers.print())
	    .andExpect(view().name(containsString("redirect:/article/view/+ comment.getArticle().getSlug()")))
	    .andExpect(flash().attributeExists("message"))
	    ;
		
		assertThat(commentService.list().spliterator().getExactSizeIfKnown(), is(size + 1L));

	}
	
	/**
	 * @author Luciane
	 * @Date: 03/04/2016
	 * Description: Test to save a form with bad data.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testToSaveACommentWithBadData() throws Exception {
		
		/*Long size = commentService.list().spliterator().getExactSizeIfKnown();
		
		mockMvc.perform(post("/article/comment/save")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("content", "is a content")
                .sessionAttr("comment", new Comment())
        )
	    .andDo(MockMvcResultHandlers.print())
	    .andExpect(status().isOk())
	    .andExpect(view().name("/article/view"))
	   // "redirect:/article/view/" + comment.getArticle().getSlug();
	    ;
		
		assertThat(commentService.list().spliterator().getExactSizeIfKnown(), is(size));*/

	}

	/**
	 * @author Luciane
	 * @Date: 03/04/2016
	 * Description: Test to check comment1 delete it and check again.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testToCheckComment1DeleteItAndCheckAgain() throws Exception {
		
		/*assertThat(commentService.get(1L).getContent(), is("Comment number one"));
		
		this.mockMvc.perform(post("/article/comment/delete/1"))
			.andExpect(flash().attributeExists("message"))
			;
		
		assertThat(commentService.get(1L), is(nullValue()));*/

	}
	
	/**
	 * @author Luciane
	 * @Date: 03/04/2016
	 * Description: Test to delete item100 that does not exists.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testToDeleteComment100ThatDoesNotExists() throws Exception {
		
		/*assertThat(commentService.get(100L), is(nullValue()));
		
		this.mockMvc.perform(post("/article/comment/delete/100"))
		.andExpect(view().name("/article/view"))
		.andExpect(status().isOk())
		.andExpect(model().attribute("message", containsString("failed to delete")))
		;*/

	}
	
		
}
