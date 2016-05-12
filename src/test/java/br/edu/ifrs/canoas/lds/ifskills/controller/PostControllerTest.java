package br.edu.ifrs.canoas.lds.ifskills.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.edu.ifrs.canoas.lds.ifskills.IFSkillsApplication;
import br.edu.ifrs.canoas.lds.ifskills.service.JobAdService;
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

}
