/**
 * @author: Fernando Sturzbecher
 * @date: 31/03/2016
 * @description: The controller for our applications
 */
package br.edu.ifrs.canoas.lds.ifskills.controller;

import java.text.MessageFormat;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifrs.canoas.lds.ifskills.domain.TrainerApplication;
import br.edu.ifrs.canoas.lds.ifskills.service.TrainerApplicationService;

// TODO: Auto-generated Javadoc
@Controller
@RequestMapping("/applications")
public class TrainerApplicationController {

	private TrainerApplicationService trainerApplicationService;
	private MessageSource messageSource;

	/**
	 * Instantiates a new trainer application controller.
	 *
	 * @param trainer application
	 *            the trainer application
	 * @param messageSource
	 *            the message source
	 */
	@Autowired
	public TrainerApplicationController(TrainerApplicationService trainerApplicationService,
			MessageSource messageSource) {
		this.trainerApplicationService = trainerApplicationService;
		this.messageSource = messageSource;
	}

	/**
	 * List.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("trainerApplications", trainerApplicationService.list());
		return "/applications/list";
	}

	/**
	 * Delete.
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
		TrainerApplication trainerApplication = trainerApplicationService.get(id);
		trainerApplicationService.delete(id);

		redirectAttrs.addFlashAttribute("message",
				MessageFormat.format(messageSource.getMessage("trainerApplication.deleted", null, locale), trainerApplication.getBriefSummary()));

		return "redirect:/applications/list";
	}

	/**
	 * Creates the.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping("/create")
	public String create(Model model) {
		model.addAttribute("trainerApplication", new TrainerApplication());
		model.addAttribute("readonly", false);
		return "/applications/form";
	}

	/**
	 * View.
	 *
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping("/view/{id}")
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("trainerApplication", trainerApplicationService.get(id));
		model.addAttribute("readonly", true);
		return "/applications/form";
	}

	/**
	 * Update.
	 *
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping("/edit/{id}")
	public String update(@PathVariable Long id, Model model) {
		model.addAttribute("trainerApplication", trainerApplicationService.get(id));
		model.addAttribute("readonly", false);
		return "/applications/form";
	}

	/**
	 * Save.
	 *
	 * @param trainerApplication
	 *            the trainerApplication
	 * @param bindingResult
	 *            the binding result
	 * @param model
	 *            the model
	 * @param redirectAttrs
	 *            the redirect attrs
	 * @param locale
	 *            the locale
	 * @return the string
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid TrainerApplication trainerApplication, BindingResult bindingResult, Model model, RedirectAttributes redirectAttrs,
			Locale locale) {
		if (!bindingResult.hasErrors()) {
			TrainerApplication savedTrainerApplication = trainerApplicationService.save(trainerApplication);
			model.addAttribute("readonly", true);

			redirectAttrs.addFlashAttribute("message", messageSource.getMessage("trainerApplication.saved", null, locale));

			return "redirect:/applications/view/" + savedTrainerApplication.getId() + "?success";
		}
		model.addAttribute("readonly", false);
		return "/applications/form";
	}

}
