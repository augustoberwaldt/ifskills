package br.edu.ifrs.canoas.lds.ifskills.controller;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
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
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.edu.ifrs.canoas.lds.ifskills.IFSkillsApplication;
import br.edu.ifrs.canoas.lds.ifskills.service.JobAdService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(IFSkillsApplication.class)
public class JobAdControllerTest extends BaseControllerTest{
	
	@Autowired 
	JobAdController jobAdController;
	
	@Autowired
    private JobAdService jobAdService;
	
	@Before
	public void setup() {
		mockMvc = getMockMvc(jobAdController);
	}
	
	/**
	 * @author Luciane
	 * Date: 18/04/2016
	 * Description: Test to list all Job's and check attributes.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testToListStatusApprovedAllIJobAdAndCheckAttributes() throws Exception {
		this.mockMvc.perform(post("/job/list"))
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("jobs"))
		.andExpect(model().attribute("jobs", hasSize(2)))
		.andExpect(model().attribute("jobs", hasItem(
                allOf(
                        hasProperty("id", is(1L)),
                        hasProperty("benefits", is("Vale-refeição e Vale transporte")),
                        hasProperty("educationLevelRequired", is("Ensino Superior"))
                )
        )))
		.andExpect(forwardedUrl(PRE_URL+"/job/list"+POS_URL))
		;
	}

	/**
	 * @author Luciane
	 * @Date: 18/04/2016
	 * Description: Test to check Job3, delete it and check again.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	@WithUserDetails("admin@123.123")
	public void testToCheckJobAd3DeleteItAndCheckAgain() throws Exception {
		
		assertThat(jobAdService.get(3L), is(notNullValue()));
		assertThat(jobAdService.get(3L).getBusinessArea(), is("IT"));
		
		this.mockMvc.perform(post("/job/delete/3"))
			.andExpect(flash().attributeExists("message"))
			;
		
		assertThat(jobAdService.get(3L), is(nullValue()));

	}

	/**
	 * @author Luciane
	 * @Date: 18/04/2016
	 * Description: Test to delete JobAd1000 that does not exists.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	@WithUserDetails("admin@123.123")
	public void testToDeleteJobAd1000ThatDoesNotExists() throws Exception {
		
		assertThat(jobAdService.get(1000L), is(nullValue()));
		
		this.mockMvc.perform(post("/job/delete/1000"))
		.andExpect(view().name("redirect:/job/list"))
		.andExpect(status().is3xxRedirection())
		//.andExpect(model().attribute("message3", containsString("Job failed to delete!")))
		;

	}

	
	/**
	 * @author Luciane
	 * @Date: 18/04/2016
	 * Description: Test to delete JobAd2 with invalid email.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	@WithUserDetails("admin@123.123")
	public void testToDeleteJobAd2WithInvalidEmail() throws Exception {
		assertThat(jobAdService.get(2L), is(notNullValue()));
		assertThat(jobAdService.get(2L).getBenefits(), is("Meal ticket and Health Insurance"));
		this.mockMvc.perform(post("/job/delete/2"))
		.andExpect(view().name("redirect:/job/list"))
		.andExpect(status().is3xxRedirection())
		.andExpect(flash().attributeExists("message"));	
	}

	/**
	 * @author Luciane
	 * @Date: 18/04/2016
	 * Description: Test to view jobAD1 and check atts.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testToViewJobAd1AndCheckAtts() throws Exception {
		this.mockMvc.perform(post("/job/view/1"))
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("job"))
		.andExpect(model().attribute("job", hasProperty("title", is("Vaga TI"))))
		.andExpect(model().attribute("readonly",is(true)))
		.andExpect(forwardedUrl(PRE_URL+"/job/form"+POS_URL))
		;

		
	}
	
	/**
	 * @author Luciane
	 * @Date: /04/2016
	 * Description: Test method search
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public void testShowJobAdListAndCheckAtts() throws Exception{
		/*this.mockMvc.perform(post("/job/search/Porto+Alegre"))
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("jobs"))
		.andExpect(model().attribute("jobs", hasSize(1)))
		.andExpect(model().attribute("jobs", hasItem(
                allOf(
                        hasProperty("id", is(1L)),
                        hasProperty("title", is("Vaga TI")),
                        hasProperty("benefits", is("Vale-refeição e Vale transporte"))
                )
        )))
		.andExpect(forwardedUrl(PRE_URL+"/job/list"+POS_URL))
		;*/
	}

}
