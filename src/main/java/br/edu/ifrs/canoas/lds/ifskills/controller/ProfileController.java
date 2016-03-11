package br.edu.ifrs.canoas.lds.ifskills.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		model.addAttribute("profile", userProfileService.get(id));
		model.addAttribute("readonly", true);
		return "/profile/form";
	}//tentativa 09/03
	
	
	@RequestMapping(value = "/searchBy", method = RequestMethod.POST)
	public String showUserList(Model model,final HttpServletRequest req) {
		model.addAttribute("users", userProfileService.list(req.getParameter("criteria")));
		return "/profile/list";
	}	


}