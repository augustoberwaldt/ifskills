/**
 * @author Luciane
 * Date: 14/04/2016
 * Description: Controller Job Ad class
 */
package br.edu.ifrs.canoas.lds.ifskills.controller;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.MailException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifrs.canoas.lds.ifskills.domain.Item;
import br.edu.ifrs.canoas.lds.ifskills.domain.JobAd;
import br.edu.ifrs.canoas.lds.ifskills.service.JobAdService;

@Controller
@RequestMapping("/job")
public class JobAdController {
	
	private JobAdService jobAdService;
	private MessageSource messageSource;
		
	
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
	public JobAdController(JobAdService jobAdService, MessageSource messageSource) {
		
		this.jobAdService = jobAdService;
		this.messageSource = messageSource;
	}
	
	/**
	 * @author Luciane
	 * Date: 14/04/2016
	 * Description: Method List.
	 * 
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("jobs", jobAdService.listStatusApproved());
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
			
		if (jobAd == null){
			redirectAttrs.addFlashAttribute("message3",
					MessageFormat.format(messageSource.getMessage("job.deleted.failed", null, locale),null));
			
		}
		else{
			 try {
				 jobAdService.sendMessage(jobAd);
				  redirectAttrs.addFlashAttribute("message2",
							 MessageFormat.format(messageSource.getMessage("job.mail.sent", null, locale), null));
				
				}catch( MailException e){
					redirectAttrs.addFlashAttribute("message2",
							 MessageFormat.format(messageSource.getMessage("job.mail.failed", null, locale), null));
	
			 }
			
			jobAdService.delete(id);
	
			redirectAttrs.addFlashAttribute("message",
					MessageFormat.format(messageSource.getMessage("job.deleted", null, locale), jobAd.getDescription()));
		}

		return "redirect:/job/list"; 

		
	}
		
	/**
	 * @author Luciane
	 * Date: 14/04/2016
	 * Description: Method View.
	 *
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping("/view/{id}")
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("job", jobAdService.get(id));
		model.addAttribute("readonly", true);
		return "/job/form";
	}
	
	/**
	 * @author Luciane
	 * Date: 14/04/2016
	 * Description: Method Show job list.
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
				model.addAttribute("message",
						messageSource.getMessage("job.searchFailed", null, locale));
			}
			model.addAttribute("jobs", jobs);
		} else if (criteria != null && criteria.isEmpty()) {
			model.addAttribute("jobs", new ArrayList<JobAd>());//jobAdService.list(criteria)
			model.addAttribute("message", messageSource.getMessage("job.validatorCriteria", null, locale));
		}

		return "/job/list";
	}
	
	
	/**
	 * @author Aline G.
	 * Date: 22/04/2016
	 * Description: Method to avaliate the JobAd.
	 *
	 */
	@RequestMapping("/approve")
	public String approve(Model model) {
		model.addAttribute("jobs", jobAdService.listWaitingJobAds());
		return "/job/list";
	}
	
	
	
	
	
}
