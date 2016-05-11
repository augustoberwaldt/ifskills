package br.edu.ifrs.canoas.lds.ifskills.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.edu.ifrs.canoas.lds.ifskills.IFSkillsApplication;
import br.edu.ifrs.canoas.lds.ifskills.domain.Comment;

//TODO: Auto-generated Javadoc
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(IFSkillsApplication.class)
public class CommentServiceTest {
	
	@Autowired
	CommentService commentService;
	
	/**
	 * @author Luciane
	 * @Date: 03/04/2016
	 * @Description: Test to list all comments.
	 */
	@Test
	public void testToListAllComments() {
		assertTrue(commentService.list().spliterator().estimateSize() > 0);
	}

	
	/**
	 * @author Luciane
	 * @Date: 03/04/2016
	 * @Description: Test to create and save an comment.
	 */
	@Test
	public void testToCreateAndSaveAnComment() {
		Comment comment = new Comment();
		comment.setBody("My Comment");
		assertThat(commentService.save(comment), hasProperty("id", is(not(empty()))));
	}

	
	/**
	 * @author Luciane
	 * @Date: 03/04/2016
	 * @Description: Test to get item1 and check name.
	 */
	@Test
	public void testToGetComment1AndCheckAuthor() {
		assertThat(commentService.get(1L), hasProperty("content", is("Comment number one")));
	}

	/**
	 * @author Luciane
	 * @Date: 03/04/2016
	 * @Description: Test to find comment1 delete it and check again.
	 * Test to find item2 delete it and check again.
	 */
	@Test
	public void testToFindComment1DeleteItAndCheckAgain() {
		assertThat(commentService.get(1L), hasProperty("content", is("Comment number one")));
		commentService.delete(1L);
		assertThat(commentService.get(1L), is(nullValue()));
	}

}
