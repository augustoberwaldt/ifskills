/**
 * @author Luciane
 * Date: 14/04/2016
 * Description: Controller Job Ad class
 */
package br.edu.ifrs.canoas.lds.ifskills.controller;

import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.MailException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifrs.canoas.lds.ifskills.domain.Address;
import br.edu.ifrs.canoas.lds.ifskills.domain.JobAd;
import br.edu.ifrs.canoas.lds.ifskills.domain.Status;
import br.edu.ifrs.canoas.lds.ifskills.domain.User;
import br.edu.ifrs.canoas.lds.ifskills.service.JobAdService;
import br.edu.ifrs.canoas.lds.ifskills.service.UserProfileService;

@Controller
@RequestMapping("/job")
public class JobAdController {
	
	private JobAdService jobAdService;
	private MessageSource messageSource;
	private UserProfileService userProfileService;
		
	
	/**
	 * @author Luciane
	 * Date: 14/04/2016
	 * Description: Instantiates a new jobAd controller.
	 *
	 * @param jobAdService
	 *            the jobAd service
	 * @param messageSource
	 *            the message source
	 */
	@Autowired
	public JobAdController(JobAdService jobAdService, MessageSource messageSource,UserProfileService userProfileService) {
		
		this.jobAdService = jobAdService;
		this.messageSource = messageSource;
		this.userProfileService= userProfileService;
	}
	
	/**
	 * @author Luciane
	 * Date: 14/04/2016
	 * Description: Method List.
	 * 
	 * Modified by: Felipe
	 * Description: List Job doesn't show any ad before research;
	 * 
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping("/list")
	public String list(Model model) {
		return "/job/list";
	}

	/**
	 * @author Luciane
	 * Date: 14/04/2016
	 * Description: Method Delete an Job Ad.
	 * 
	 * Modified by: Luciane
	 * Date: 17/04/2016
	 * Description: Implementation of the sending mail
	 * 
	 * Modified by Luciane
	 * Date: 26/04/2016
	 * Implements validations
	 *
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 * @param redirectAttrs
	 *            the redirect attrs
	 * @param locale
	 *            the locale
	 * @return the string
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model, RedirectAttributes redirectAttrs, Locale locale) {

		JobAd jobAd = jobAdService.get(id);

		if (jobAd == null) {
			redirectAttrs.addFlashAttribute("message",
					MessageFormat.format(messageSource.getMessage("job.deleted.failed", null, locale), null));

		} else {
			try {
				jobAdService.sendMessage(jobAd);
				redirectAttrs.addFlashAttribute("message",
						MessageFormat.format(messageSource.getMessage("job.mail.sent", null, locale), null));

			} catch (MailException e) {
				redirectAttrs.addFlashAttribute("message",
						MessageFormat.format(messageSource.getMessage("job.mail.failed", null, locale), null));

			}
			
			jobAdService.delete(id);

			redirectAttrs.addFlashAttribute("message", MessageFormat
					.format(messageSource.getMessage("job.deleted", null, locale), jobAd.getDescription()));
		}

		return "redirect:/job/list";

	}
		
	/**
	 * @author Luciane 
	 * Date: 14/04/2016 
	 * Description: Method View.
	 * 
	 * Modified by Luciane
	 * Date: 26/04/2016
	 * Implements validations
	 *
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping("/view/{id}")
	public String view(@PathVariable Long id, Model model, RedirectAttributes redirectAttrs, Locale locale) {
		JobAd jobAd = jobAdService.get(id);

		if (jobAd == null) {
			redirectAttrs.addFlashAttribute("message",
					MessageFormat.format(messageSource.getMessage("job.searchFailed", null, locale), id));
			return "redirect:/job/list";
		}

		model.addAttribute("job", jobAdService.get(id));
		model.addAttribute("readonly", true);

		return "/job/form";
	}
	
	/**
	 * @author Luciane
	 * Date: 14/04/2016
	 * Description: Method Show job list.
	 * 
	 * Modified by Luciane
	 * Date: 26/04/2016
	 * Implements validations
	 * 
	 *
	 * @param model
	 *            the model
	 * @param req
	 *            the req
	 * @param locale
	 *            the locale
	 * @return the string
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String showJobAdList(Model model, final HttpServletRequest req, final Locale locale) {
		String criteria = req.getParameter("criteria");
		if (criteria != null && !criteria.isEmpty()) {
			List<JobAd> jobs = jobAdService.list(criteria);
			if (jobs.isEmpty()) {
				model.addAttribute("message", messageSource.getMessage("job.searchFailed", null, locale));
			}
			model.addAttribute("jobs", jobs);
		} else if (criteria != null && criteria.isEmpty()) {
			model.addAttribute("message", messageSource.getMessage("job.validatorCriteria", null, locale));
		}
		return "/job/list";
	}
	/**
	 * @author Felipe
	 * Date: 27/04/2016
	 * Description : show job ads for visitors
	 * @param model
	 * @param req
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = "/visitor", method = RequestMethod.GET)
	public String showJobAdListVisitor(Model model, final HttpServletRequest req, final Locale locale) {
		String criteria = req.getParameter("criteria");
		if (criteria != null && !criteria.isEmpty()) {
			List<JobAd> jobs = jobAdService.listvisitor(criteria);
			if (jobs.isEmpty()) {
				model.addAttribute("message", messageSource.getMessage("job.searchFailed", null, locale));
			}
			model.addAttribute("jobs", jobs);
		} else if (criteria != null && criteria.isEmpty()) {
			model.addAttribute("message", messageSource.getMessage("job.validatorCriteria", null, locale));
		}
		return "/job/list";
	}

	
	/**
	 * @author Aline G.
	 * Date: 22/04/2016
	 * Description: Method to list only JobAds with "Waiting" status in approve item in menu.
	 *
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping("/approve")
	public String evaluationList(Model model) {
		model.addAttribute("jobs", jobAdService.listWaitingJobAds());
		return "/job/list";
	}
	
	/**
	 * @author Aline G.
	 * Date: 26/04/2016
	 * Description: Method to evaluate (approve or reject) JobAds.
	 *
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/evaluate",  method = RequestMethod.POST)
	public String evaluate(JobAd job, Model model, RedirectAttributes redirectAttrs,
			Locale locale) {
		
		//I tried this to solve transient attribute (employer) issues. 
		//I loaded the employer from DB and then set it again in job.
		User employer = userProfileService.findByFullName(job.getEmployer().getFullName());
		job.setEmployer(employer);
		job.setJustification(job.getJustification());
		
		//I couldn't find a way to know which button User clicked on, 
		//So I did this poor condition only because I don't have time to fix it anymore :(
		if (job.getJustification().isEmpty()) {
			job.setStatus((Enum.valueOf(Status.class, "Approved")));
			job.setStatusName("Approved");
		} else {
			job.setStatus((Enum.valueOf(Status.class, "Rejected")));
			job.setStatusName("Rejected");
		  }
		
		try {
			//saves the changes (addiction of justification (rejection case) and change of status);
            JobAd savedJobAd = jobAdService.save(job);
            model.addAttribute("readonly", true);
			
				//sends notification e-mail;
				try {
				jobAdService.sendEvaluationMessage(job);
					redirectAttrs.addFlashAttribute("message2",
							MessageFormat.format(messageSource.getMessage("job.mail.sent", null, locale), null));

				} catch (MailException e) {
					redirectAttrs.addFlashAttribute("message4",
						MessageFormat.format(messageSource.getMessage("job.mail.failed", null, locale), null));

				}
				
			redirectAttrs.addFlashAttribute("message", 
					MessageFormat.format(messageSource.getMessage("job.evaluation.success", null, locale), null));

	        return "redirect:/job/view/" + savedJobAd.getId() + "?success";
				
			} catch (Exception e) {
				redirectAttrs.addFlashAttribute("message5",
						MessageFormat.format(messageSource.getMessage("job.evaluation.failed", null, locale), null));	
				model.addAttribute("readonly", false);
				return "/job/form";
			}
		
	}
	
	//@author Fernando Sturzbecher
	//Date: 25/04/16
	//Description: Method to create a new Job Ad.

	@RequestMapping("/create")
	public String create(Model model) {
		JobAd jobAd= new JobAd();
		jobAd.setEmployer(userProfileService.getPrincipal().getUser());
		jobAd.setStatus(Enum.valueOf(Status.class, "Waiting"));
		model.addAttribute("job", jobAd);
		model.addAttribute("readonly", false);
		return "/job/form";
	}
	
	//@author Fernando Sturzbecher
	//Date: 25/04/16
	//Description: Method to save a Job Ad.
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid JobAd jobAd, BindingResult bindingResult, Model model, RedirectAttributes redirectAttrs,
			Locale locale) {
		if (!bindingResult.hasErrors()) {
			JobAd savedJobAd = jobAdService.save(jobAd);
			model.addAttribute("readonly", true);

			redirectAttrs.addFlashAttribute("message", messageSource.getMessage("jobAd.saved", null, locale));

			return "redirect:/job/view/" + savedJobAd.getId() + "?success";
		}
		model.addAttribute("readonly", false);
		return "/job/form";
	}
}
