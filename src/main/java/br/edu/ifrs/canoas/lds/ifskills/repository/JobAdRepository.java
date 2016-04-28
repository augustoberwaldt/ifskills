package br.edu.ifrs.canoas.lds.ifskills.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import br.edu.ifrs.canoas.lds.ifskills.domain.JobAd;
import br.edu.ifrs.canoas.lds.ifskills.domain.Status;


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
	List<JobAd> findAllByDescriptionContainingOrRequirementsContainingOrBusinessAreaContainingOrEducationLevelRequiredContainingOrBenefitsContainingOrContactInfoContainingOrEmployer_FullNameContainingOrTitleContainingOrStatusOrLocationPlaceDescriptionContainingOrTagsContainingAllIgnoreCase(
			String description, String requirements, String businessArea, String educationLevelRequired, String benefits, String contactInfo, String fullName, String title, Status status, String city, String tags);
	/**
	 * @author Felipe
	 * Date 27/04/2016
	 * Description: Find by specific properties
	 * 
	 * @param description
	 * @param tags
	 * @param requirements
	 * @param city
	 * @param country
	 * @param state
	 * @return
	 */
	List<JobAd> findAllByDescriptionContainingOrTagsContainingOrRequirementsContainingOrLocationPlaceDescriptionContainingAllIgnoreCase(String description, String tags, String requirements, String city);
	
	
	/**
	*  @author Aline G
	* Date: 22/04/2016
	* Description: Method that finds Job Ads by status
	* 
	* Modified by Luciane
	* Date: 22/04/2016
	* Description: Change parameter Enum enum for Status status
	*
	**/
	List<JobAd> findByStatus(Status status);

}
