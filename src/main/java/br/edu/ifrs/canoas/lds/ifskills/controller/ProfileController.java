package br.edu.ifrs.canoas.lds.ifskills.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifrs.canoas.lds.ifskills.service.UserProfileService;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	private UserProfileService userProfileService;

	@Autowired
	public ProfileController(UserProfileService service) {
		this.userProfileService = service;
	}

	@RequestMapping("/search")
	public String list(Model model) {
		model.addAttribute("users", userProfileService.list());
		return "/profile/list";
	}
	
	@RequestMapping("/view/{id}")
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("profile", userProfileService.get(id));
		model.addAttribute("readonly", true);
		return "/profile/form";
	}//tentativa 09/03
	

}
