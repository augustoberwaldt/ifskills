package br.edu.ifrs.canoas.lds.ifskills.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.edu.ifrs.canoas.lds.ifskills.IFSkillsApplication;
import br.edu.ifrs.canoas.lds.ifskills.controller.BaseControllerTest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(IFSkillsApplication.class)
public class JobAdServiceTest  extends BaseControllerTest{
	
	@Autowired
	JobAdService jobAdService;
	
	/**
	 * @author Luciane
	 * Date: 18/04/2016
	 * Description: Test to list all job's.
	 */
	@Test
	public void testToListAllJobAds() {
		assertTrue(jobAdService.list().spliterator().estimateSize() > 0);
	}

	/**
	 *  @author Luciane
	 * Date: 18/04/2016
	 * Description: Test to get jobAd1 and check title.
	 */
	@Test
	public void testToGetJobAd1AndCheckTitle() {
		assertThat(jobAdService.get(1L), hasProperty("requirements", is("Escolaridade Mínima: Ensino Superior Inglês (Intermediário - Requerido) Programação: C#, JavaScript, jQuery, PHP")));
	}
	
	
	/**
	 *  @author Luciane
	 * Date: 18/04/2016
	 * Description: Test to find jobAd4 delete it and check again.
	 */
	@Test  
	public void testToFindJobAd4DeleteItAndCheckAgain() {
		assertThat(jobAdService.get(4L), hasProperty("businessArea", is("Marketing")));
		jobAdService.delete(4L);
		assertThat(jobAdService.get(4L), is(nullValue()));
	}
	

	
	
	/**
	 *  @author Luciane
	 * Date: /04/2016
	 * Description: Este teste só vou fazer depois de definir o método search
	 */
	@Test
	public void testListString() {
		//fail("Not yet implemented");
	}

}
