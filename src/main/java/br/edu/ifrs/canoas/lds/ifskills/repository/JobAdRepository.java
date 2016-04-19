package br.edu.ifrs.canoas.lds.ifskills.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifrs.canoas.lds.ifskills.domain.JobAd;


public interface JobAdRepository extends CrudRepository<JobAd, Long> {

	/**
	 *  @author Luciane
	 * Date: 14/04/2016
	 * Description: Find by all  properties of class JobAd.
	 *
	 * @param fullName
	 *            the full name
	 * @param email
	 *            the email
	 * @return the list
	 */
	List<JobAd> findAllByDescriptionContainingOrRequirementsContainingOrBusinessAreaContainingOrEducationLevelRequiredContainingOrBenefitsContainingOrContactInfoContainingAllIgnoreCase(String description, String requirements, String businessArea, String educationLevelRequired, String benefits, String contactInfo);

}
