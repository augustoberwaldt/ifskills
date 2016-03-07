package br.edu.ifrs.canoas.lds.ifskills.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.edu.ifrs.canoas.lds.ifskills.domain.User;
import br.edu.ifrs.canoas.lds.ifskills.service.ManageUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private ManageUserService service;
	
	@Autowired
	public UserController(ManageUserService service) {
		this.service=service;
	}
	
	@RequestMapping("/view")
	public String view(Model model){
		model.addAttribute("user", service.getPrincipal().getUser());
		return "/user/view";
	}
	
	@RequestMapping("/profile")
	public String profile(Model model){
		model.addAttribute("user", service.getPrincipal().getUser());
		return "/user/profile";
	}
	
	@RequestMapping( value = "/save", method = RequestMethod.POST )
	public String save(@Valid User user, BindingResult bindingResult,HttpSession session, 
			Model model, @RequestParam("userProfilePic") MultipartFile picture) throws IOException {

		if( bindingResult.hasErrors() ){
			return "/user/profile";
		} else {
			user.setPicture(picture.getBytes());
			User savedUser = service.save(user);
			service.getPrincipal().setUser(savedUser);
			session.setAttribute("pictureBase64", service.getPrincipal().getUser().getPictureBase64());
			return "/user/view";			
		}

	}
	
}
