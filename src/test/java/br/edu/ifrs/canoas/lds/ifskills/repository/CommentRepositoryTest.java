package br.edu.ifrs.canoas.lds.ifskills.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.edu.ifrs.canoas.lds.ifskills.IFSkillsApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(IFSkillsApplication.class)
public class CommentRepositoryTest {
	
	@Autowired
	CommentRepository commentRepository;

	
	/**
	 * @author Luciane
	 * @Date:30/03/2016
	 * @Descrition: Test to findOne comment and check 
	 * property content.
	 */
	@Test
	public void testFindOneCommentAndCheckPropertyComment() {
		assertThat(commentRepository.findOne(1L), hasProperty("content", is("Comment number one")));
	}
	
	/**
	 * @author Luciane
	 * @Date:30/03/2016
	 * @Descrition: Test to find all comments that are checked.
	 */
	@Test
	public void testToFindAllComments() {
		assertThat(commentRepository.findAll().size(), is(1));
	}

}
