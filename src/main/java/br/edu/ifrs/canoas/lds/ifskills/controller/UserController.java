/*
 * 
 */
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
import br.edu.ifrs.canoas.lds.ifskills.service.UserProfileService;

// TODO: Auto-generated Javadoc
@Controller
@RequestMapping("/user")
public class UserController {

	private UserProfileService service;

	/**
	 * Instantiates a new user controller.
	 *
	 * @param service
	 *            the service
	 */
	@Autowired
	public UserController(UserProfileService service) {
		this.service = service;
	}

	/**
	 * View.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping("/view")
	public String view(Model model) {
		model.addAttribute("user", service.getPrincipal().getUser());
		return "/user/view";
	}

	/**
	 * Profile.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping("/profile")
	public String profile(Model model) {
		model.addAttribute("user", service.getPrincipal().getUser());
		return "/user/profile";
	}

	/**
	 * Save.
	 *
	 * @param user
	 *            the user
	 * @param bindingResult
	 *            the binding result
	 * @param session
	 *            the session
	 * @param model
	 *            the model
	 * @param picture
	 *            the picture
	 * @return the string
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid User user, BindingResult bindingResult, HttpSession session, Model model,
			@RequestParam("userProfilePic") MultipartFile picture) throws IOException {

		if (bindingResult.hasErrors()) {
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
