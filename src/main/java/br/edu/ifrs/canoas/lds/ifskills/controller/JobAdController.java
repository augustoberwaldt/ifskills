/**
 * @author Luciane
 * Date: 14/04/2016
 * Description: Controller Job Ad class
 */
package br.edu.ifrs.canoas.lds.ifskills.controller;

import java.text.MessageFormat;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifrs.canoas.lds.ifskills.domain.JobAd;
import br.edu.ifrs.canoas.lds.ifskills.service.JobAdService;

@Controller
@RequestMapping("/job")
public class JobAdController {
	private JobAdService jobAdService;
	//private UserProfileService userProfileService;
	
	
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
	
	private MessageSource messageSource;
	
	
	@Autowired
	public JobAdController(JobAdService jobAdService, MessageSource messageSource) {
		
		this.jobAdService = jobAdService;
		this.messageSource = messageSource;
	}
	
	/**
	 * @author Luciane
	 * Date: 14/04/2016
	 * Description: Method List.
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("jobs", jobAdService.list());
		return "/job/list";
	}

	/**
	 * @author Luciane
	 * Date: 14/04/2016
	 * Description: Method Delete.
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
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model, RedirectAttributes redirectAttrs, Locale locale) {
		JobAd jobAd = jobAdService.get(id);
		jobAdService.delete(id);

		redirectAttrs.addFlashAttribute("message",
				MessageFormat.format(messageSource.getMessage("jobAd.deleted", null, locale), jobAd.getDescription()));

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

	
	
	

}
