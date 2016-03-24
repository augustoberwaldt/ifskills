/**
 * @author:
 * @date: 
 * @description: 
 */
package br.edu.ifrs.canoas.lds.ifskills.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifrs.canoas.lds.ifskills.domain.Article;
import br.edu.ifrs.canoas.lds.ifskills.domain.User;
import br.edu.ifrs.canoas.lds.ifskills.service.ArticleService;
import br.edu.ifrs.canoas.lds.ifskills.service.UserProfileService;

// TODO: Auto-generated Javadoc
@Controller
public class HomeController {
	
	private UserProfileService service;
	private ArticleService articleService;
	
	/**
	 * Instantiates a new home controller.
	 *
	 * @param service
	 *            the service
	 * @param articleService
	 *            the article service
	 */
	@Autowired
	public HomeController(UserProfileService service, ArticleService articleService) {
		this.service = service;
		this.articleService = articleService;
	}

	/**
	 * View.
	 *
	 * @param model
	 *            the model
	 * @param session
	 *            the session
	 * @return the string
	 */
	@RequestMapping("/")
	public String view(Model model, HttpSession session){
		if (service.getPrincipal() != null && service.getPrincipal().getUser() != null)
			session.setAttribute("pictureBase64", ""+service.getPrincipal().getUser().getPictureBase64());
		
		model.addAttribute("articles", articleService.findAll());
		return "/index";
	}
}
