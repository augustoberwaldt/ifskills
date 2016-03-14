package br.edu.ifrs.canoas.lds.ifskills.controller;

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

	@RequestMapping("/search")
	public String list(Model model){
		model.addAttribute("users", new ArrayList());
		return "/profile/list";
	}
	
	@RequestMapping("/view/{id}")
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("user", userProfileService.get(id));
		model.addAttribute("readonly", true);
		return "/profile/form";
	}
	
	@RequestMapping(value = "/searchBy", method = RequestMethod.POST)
	public String showUserList(Model model,final HttpServletRequest req, final Locale locale) {
		List<User> users = userProfileService.list(req.getParameter("criteria"));
		if(users.isEmpty()){
			model.addAttribute("message", 
					messageSource.getMessage("profile.findAllByFullNameOrEmailAllIgnoreCase", null, locale));
		}
		model.addAttribute("users", users);
		return "/profile/list";	
	}	


}