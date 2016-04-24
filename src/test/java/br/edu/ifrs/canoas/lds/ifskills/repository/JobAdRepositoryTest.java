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
public class JobAdRepositoryTest {
	
	@Autowired
	JobAdRepository jobAdRepository;
	
	/**
	 *  @author Luciane
	 * Date: 23/04/2016
	 * Description: Test method find by all property of Job Ad
	 */
	@Test
	public void testFindAllByPropertiesOfJobAd() {
		//assertThat(jobAdRepository.findAllByDescriptionContainingOrRequirementsContainingOrBusinessAreaContainingOrEducationLevelRequiredContainingOrBenefitsContainingOrContactInfoContainingOrEmployer_FullNameContainingOrTitleContainingOrStatusContainingOrLocationPlaceDescriptionContainingOrTagsContainingAllIgnoreCase("Nível hierárquico: Operacional, Regime de contratação de tipo Efetivo – CLT Jornada Período Integral", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ").size(), is(6));
		//assertThat(jobAdRepository.findAllByDescriptionContainingOrRequirementsContainingOrBusinessAreaContainingOrEducationLevelRequiredContainingOrBenefitsContainingOrContactInfoContainingOrEmployer_FullNameContainingOrTitleContainingOrStatusContainingOrLocationPlaceDescriptionContainingOrTagsContainingAllIgnoreCase("", "Written Communication, Organization, Statistical Analysis, General Math, Microsoft Office, Self-Development, Financial Skills", " ", " ", " ", " ", " ", " ", " ", " ", " ").size(), is(6));
		assertTrue(jobAdRepository.findAllByDescriptionContainingOrRequirementsContainingOrBusinessAreaContainingOrEducationLevelRequiredContainingOrBenefitsContainingOrContactInfoContainingOrEmployer_FullNameContainingOrTitleContainingOrStatusContainingOrLocationPlaceDescriptionContainingOrTagsContainingAllIgnoreCase("strategies", "", "", "", "", "", "", "", "", "", "").spliterator().estimateSize() > 0);
	}
	
	/**
	*  @author Aline G
	* Date: 
	* Description: 
	*
	**/
	@Test
	public void testFindByStatus() {
		//assertThat(jobAdRepository.findByStatus("Approved"), hasProperty("title", is("Get With the Program")));
	}

}
