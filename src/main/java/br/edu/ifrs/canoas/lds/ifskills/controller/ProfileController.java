package br.edu.ifrs.canoas.lds.ifskills.controller;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifrs.canoas.lds.ifskills.domain.User;
import br.edu.ifrs.canoas.lds.ifskills.service.UserProfileService;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	private UserProfileService userProfileService;
	private MessageSource messageSource;

	@Autowired
	public ProfileController(UserProfileService service, MessageSource messageSource) {
		this.userProfileService = service;
		this.messageSource = messageSource;
	}

	@RequestMapping("/edit/{id}")
	public String update(@PathVariable Long id, Model model) {
		model.addAttribute("user", userProfileService.get(id));
		model.addAttribute("readonly", false);
		return "/profile/form";
	}
	

	@RequestMapping("/view/{id}")
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("user", userProfileService.get(id));
		model.addAttribute("readonly", true);
		return "/profile/form";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model, RedirectAttributes redirectAttrs, Locale locale) {
		User user = userProfileService.get(id);
		if (user != null) {
			userProfileService.delete(id);

			redirectAttrs.addFlashAttribute("message",
					MessageFormat.format(messageSource.getMessage("user.deleted", null, locale), user.getFullName()));

			return "redirect:/profile/list";
		}
		model.addAttribute("message",
				MessageFormat.format(messageSource.getMessage("item.deleted.failed", null, locale), id));
		return "/profile/form";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String showUserList(Model model, final HttpServletRequest req, final Locale locale) {
		String criteria = req.getParameter("criteria");
		if (criteria != null && !criteria.isEmpty()) {
			List<User> users = userProfileService.list(criteria);
			if (users.isEmpty()) {
				model.addAttribute("message",
						messageSource.getMessage("profile.findAllByFullNameOrEmailAllIgnoreCase", null, locale));
			}
			model.addAttribute("users", users);
		} else if (criteria != null && criteria.isEmpty()) {
			// Eu queria disparar uma mensagem ao usuário, caso ele
			// clique no botão search do form, sem antes ter escrito algo no
			// campo de busca!
			// Fiquei em dúvida porque já tem um evento "onclick" no botão do
			// form.
			// Gostaria de saber que outras validações poderia fazer???
			model.addAttribute("users", new ArrayList<User>());
			model.addAttribute("message", messageSource.getMessage("profile.validatorCriteria", null, locale));
		}

		return "/profile/list";
	}

}
