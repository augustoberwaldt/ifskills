package br.edu.ifrs.canoas.lds.ifskills.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifrs.canoas.lds.ifskills.domain.Item;
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
		model.addAttribute("users", userProfileService.list());
		return "/profile/list";
	}
	
	@RequestMapping("/view/{id}")
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("profile", userProfileService.get(id));
		model.addAttribute("readonly", true);
		return "/profile/form";
	}//tentativa 09/03
	
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String save(@Valid User user, BindingResult bindingResult, Model model, RedirectAttributes redirectAttrs, Locale locale) {
		if(!bindingResult.hasErrors() ){
			User savedProfile = userProfileService.save(user);
			model.addAttribute("readonly", true);
			
			redirectAttrs.addFlashAttribute("message", messageSource.getMessage("item.saved", null, locale));
			
			return "redirect:/profile/list/" + savedProfile.getId()+"?success";		
		}
		model.addAttribute("readonly", false);
		return "/profile/list";
	}	


}
