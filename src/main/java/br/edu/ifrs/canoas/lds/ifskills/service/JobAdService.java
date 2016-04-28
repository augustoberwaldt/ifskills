/**
 * @author:
 * @date: 
 * @description: 
 */
package br.edu.ifrs.canoas.lds.ifskills.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.ifskills.domain.JobAd;
import br.edu.ifrs.canoas.lds.ifskills.domain.Status;
import br.edu.ifrs.canoas.lds.ifskills.repository.JobAdRepository;

// TODO: Auto-generated Javadoc
@Service
public class JobAdService {

	private JobAdRepository jobAdRepository;

	private NotificationService notificationService;
	
	private UserProfileService userService;
	/**
	 * Instantiates a new article service.
	 *
	 * @param artRepo
	 *            the art repo
	 */
	@Autowired
	public JobAdService(JobAdRepository jobRepo, NotificationService notificationService) {
		this.jobAdRepository = jobRepo;
		this.notificationService = notificationService;
	}
	
	/**
	 * @author Luciane
	 * Date: 14/04/2016
	 * Description: Method List.
	 * @return the iterable
	 * 
	 * Alteration: Luciane 
	 * Date: 22/04/2016
	 * Description: Changed to list only Job Ad status to "approved"
	 */
	public Iterable<JobAd> listStatusApproved() {
		return jobAdRepository.findByStatus(Enum.valueOf(Status.class, "Approved"));
	}
	
	/**
	 * @author Luciane
	 * Date: 14/04/2016
	 * Description: Method Delete.
	 *
	 * @param id
	 *            the id
	 */
	public void delete(Long id) {
		jobAdRepository.delete(id);
	}
	
	/**
	 * @author Luciane
	 * Date: 14/04/2016
	 * Description: Method Gets the.
	 *
	 * @param id
	 *            the id
	 * @return the article
	 */
	public JobAd get(Long id) {
		return jobAdRepository.findOne(id);
	}
	
	/**
	 *  @author Luciane
	 * Date: 14/04/2016
	 * Description: List the Job Ad found according to the informed discretion
	 * 
	 * @param parameter
	 *            the parameter
	 * @return the list
	 */
	public List<JobAd> list(String parameter) {
		return jobAdRepository.findAllByDescriptionContainingOrRequirementsContainingOrBusinessAreaContainingOrEducationLevelRequiredContainingOrBenefitsContainingOrContactInfoContainingOrEmployer_FullNameContainingOrTitleContainingOrStatusOrLocationPlaceDescriptionContainingOrTagsContainingAllIgnoreCase(
				parameter, parameter, parameter, parameter, parameter, parameter, parameter, parameter, Status.get(parameter), parameter, parameter);
	}
	/**
	 * @author Felipe
	 * Date: 27/04/2016
	 * Description: List the Job Ad found according to the informed discretion
	 * 
	 * @param parameter
	 * @return the list
	 */
	public List<JobAd> listvisitor(String parameter){
		return jobAdRepository.findAllByDescriptionContainingOrTagsContainingOrRequirementsContainingOrLocationPlaceDescriptionContainingAllIgnoreCase(parameter, parameter, parameter, parameter);
	}

	
	/**
	 *  @author Luciane
	 * Date: 14/04/2016
	 * Description: Responsible method for mounting the body of the email
	 * 
	 * @param parameter
	 *            the parameter
	 * @return the list
	 */
	public SimpleMailMessage sendMessage(JobAd jobAd) {
		SimpleMailMessage mail = new SimpleMailMessage();

		if (jobAd != null) {
			mail.setTo(jobAd.getEmployer().getEmail());
			mail.setFrom("labifrs2016.1@gmail.com");
			mail.setSubject("Your Job Ad was deleted");
			mail.setText(
					"Dear author " + jobAd.getEmployer().getFullName() + ", \n\n" + "Your Job Ad with a description '"
							+ jobAd.getDescription() + "' was deleted by one of our Administrators.\n"
							+ "If there's any problem with that, feel free to call us any moment.\n"
							+ "\n\nHere's a copy of your Job Ad:\n\n" + jobAd.getDescription() + "\n\n"
							+ jobAd.getBusinessArea() + "\n\n" + jobAd.getRequirements() + "\n\n"
							+ "\n\n\nBest Regards, \n" + "IFRS Lab - 2016\n");
		}

		return notificationService.sendNotification(mail);
		    
	}
	
	
	/**
	 *  @author Aline G.
	 * Date: 22/04/2016
	 * Description: Method that shows JobAds with "Waiting" status;
	 *
	 **/
	public Object listWaitingJobAds() {
		return jobAdRepository.findByStatus(Enum.valueOf(Status.class, "Waiting"));
	}	
	
	//@author Fernando Sturzbecher
	//Date: 25/04/16
	//Description: Method to save a Job Ad.
	public JobAd save(JobAd jobAds) {
		return jobAdRepository.save(jobAds);
	}			
}