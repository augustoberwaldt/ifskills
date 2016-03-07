package br.edu.ifrs.canoas.lds.ifskills.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifrs.canoas.lds.ifskills.service.UserProfileService;

@Controller
public class HomeController {
	
	private UserProfileService service;
	
	@Autowired
	public HomeController(UserProfileService service) {
		this.service=service;
	}
	
	@RequestMapping("/")
	public String view(Model model, HttpSession session){
		if (service.getPrincipal() != null && service.getPrincipal().getUser() != null)
			session.setAttribute("pictureBase64", ""+service.getPrincipal().getUser().getPictureBase64());
		return "/user/view";
	}
	
}
