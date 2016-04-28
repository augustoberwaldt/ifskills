/**
 * @author:
 * @date: 
 * @description: 
 */
package br.edu.ifrs.canoas.lds.ifskills.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.ifskills.domain.JobAd;
import br.edu.ifrs.canoas.lds.ifskills.domain.Status;
import br.edu.ifrs.canoas.lds.ifskills.repository.JobAdRepository;

// TODO: Auto-generated Javadoc
@Service
public class JobAdService {

	private JobAdRepository jobAdRepository;

	private NotificationService notificationService;
	
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
					"Dear author " + jobAd.getEmployer().getFullName() + ", \n\n" + "Your Job Ad with a title '"
							+ jobAd.getTitle() + "' was deleted by one of our Administrators.\n"
							+ "If there's any problem with that, feel free to call us any moment.\n"
							+ "\n\nHere's a copy of your Job Ad:\n\n"
							+"Description: "+ jobAd.getDescription() + "\n\n"
							+ "Business Area: " + jobAd.getBusinessArea() + "\n\n" 
							+ "Requirements: " + jobAd.getRequirements() + "\n\n"
							+ "Education Level required: " + jobAd.getEducationLevelRequired() + "\n\n"
							+ "Benefits: " + jobAd.getBenefits() + "\n\n"
							+ "\n\n\nBest Regards, \n" + "IFRS Lab - 2016\n");
		}

		return notificationService.sendNotification(mail);
		    
	}
	
	/**
	 *  @author Aline G
	 * Date: 27/04/2016
	 * Description: Method to create the body of evaluation e-mail.
	 *
	 **/
	public SimpleMailMessage sendEvaluationMessage(JobAd jobAd) {
		SimpleMailMessage mail = new SimpleMailMessage();

		if (jobAd != null) {
			mail.setTo(jobAd.getEmployer().getEmail());
			mail.setFrom("labifrs2016.1@gmail.com");
			if (jobAd.getStatusName() == "Approved") {
				mail.setSubject("Your Job Ad was approved!");
				mail.setText(
						"Dear employer " + jobAd.getEmployer().getFullName() + ", \n\n" + "Your Job named '"
								+ jobAd.getTitle() + "' was APPROVED by one of our Administrators.\n"
								+ "Now it can be viewed by all of our site members! You must take a look at it in site's main page."
								+ "Thank you for choosing BootBase to promote your Ad.\n"
								+ "\nAny questions or problems, let us now."
								+ "\n\n\nBest Regards, \n" + "IFRS Lab - 2016\n");
			} else if (jobAd.getStatusName() == "Rejected") {
				mail.setSubject("Your Job Ad was Rejected!");
				mail.setText(
						"Dear employer " + jobAd.getEmployer().getFullName() + ", \n\n" + "Your Job Ad named '"
								+ jobAd.getTitle() + "' was REJECTED by one of our Administrators.\n"
								+ "Here's the Admin justification for this evaluation: \n" + jobAd.getJustification() 
							
								+ "\n\nHere's a copy of your Job Ad:\n\n" 
								+ "Description: " + jobAd.getDescription() + "\n\n"
								+ "Business Area: " + jobAd.getBusinessArea() + "\n\n" 
								+ "Requirements: " + jobAd.getRequirements() + "\n\n"
								+ "Education Level required: " + jobAd.getEducationLevelRequired() + "\n\n"
								+ "Benefits: " + jobAd.getBenefits() + "\n\n"
							
								+ "\n\nIf there's any problem with that, feel free to call us any moment.\n"
								+ "\n\n\nBest Regards, \n" + "IFRS Lab - 2016\n");
			}
		}
		return notificationService.sendNotification(mail);		    
	}
	
	/**
	 *  @author Aline G.
	 * Date: 22/04/2016
	 * Description: Method that shows JobAds with "Waiting" status;
	 *
	 **/
	public Iterable<JobAd> listWaitingJobAds() {
		return jobAdRepository.findByStatus(Enum.valueOf(Status.class, "Waiting"));
	}	
	
	//@author Fernando Sturzbecher
	//Date: 25/04/16
	//Description: Method to save a Job Ad.
	public JobAd save(JobAd jobAds) {
		return jobAdRepository.save(jobAds);
	}			
}