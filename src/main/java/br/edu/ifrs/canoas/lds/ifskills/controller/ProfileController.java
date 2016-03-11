package br.edu.ifrs.canoas.lds.ifskills.controller;

<<<<<<< HEAD
=======
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

>>>>>>> branch 'master' of https://github.com/rodrigonoll/ifskills.git
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RequestMethod;
>>>>>>> branch 'master' of https://github.com/rodrigonoll/ifskills.git

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
<<<<<<< HEAD
	public String list(Model model) {
		model.addAttribute("users", userProfileService.list());
=======
	public String list(Model model){
		model.addAttribute("users", new ArrayList());
>>>>>>> branch 'master' of https://github.com/rodrigonoll/ifskills.git
		return "/profile/list";
	}
	
	@RequestMapping("/view/{id}")
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("profile", userProfileService.get(id));
		model.addAttribute("readonly", true);
		return "/profile/form";
	}//tentativa 09/03
	
<<<<<<< HEAD
=======
	
	@RequestMapping(value = "/searchBy", method = RequestMethod.POST)
	public String showUserList(Model model,final HttpServletRequest req) {
		model.addAttribute("users", userProfileService.list(req.getParameter("criteria")));
		return "/profile/list";
	}	

>>>>>>> branch 'master' of https://github.com/rodrigonoll/ifskills.git

}
