/**
 * @author:
 * @date: 
 * @description: 
 */
package br.edu.ifrs.canoas.lds.ifskills.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifrs.canoas.lds.ifskills.service.ArticleService;
import br.edu.ifrs.canoas.lds.ifskills.service.JobAdService;
import br.edu.ifrs.canoas.lds.ifskills.service.PostService;
import br.edu.ifrs.canoas.lds.ifskills.service.UserProfileService;

// TODO: Auto-generated Javadoc
@Controller
public class HomeController {

	private UserProfileService userService;
	private ArticleService articleService;
	private JobAdService jobAdService;
	private PostService postService; 

	/**
	 * Instantiates a new home controller.
	 *
	 * @param service
	 *            the service
	 * @param articleService
	 *            the article service
	 */
	@Autowired
	public HomeController(UserProfileService service, ArticleService articleService, JobAdService jobAdService, PostService postService) {
		this.userService = service;
		this.articleService = articleService;
		this.jobAdService = jobAdService;
		this.postService = postService;
	}

	/**
	 * View.
	 *
	 * Author: Luciane Date: 24/03/2016 Description: Method that carries 3
	 * Database items and shows the home page index.html
	 * 
	 * 03/24 - Rodrigo - added auth attribute for template decorator
	 * 
	 * 25/04 - Rodrigo - added list jobs on line 61
	 */
	@RequestMapping("/")
	public String view(Model model, HttpSession session) {
		if (userService.getPrincipal() != null && userService.getPrincipal().getUser() != null)
			session.setAttribute("pictureBase64", "" + userService.getPrincipal().getUser().getPictureBase64());

		model.addAttribute("auth", userService.getPrincipal() != null);
		if (userService.getPrincipal () != null ){
			model.addAttribute("articles", articleService.findAll());
			model.addAttribute("jobs", jobAdService.listStatusApproved());
			model.addAttribute("posts", postService.list());
			
		}else{
			model.addAttribute("articles", articleService.listPublic());
			model.addAttribute("jobs", jobAdService.listStatusApproved());
			model.addAttribute("posts", postService.listIsPublic());
			model.addAttribute("calculatedRank", new Float(2.5));
		}
		return "/index";
	}

	/**
	 * View.
	 *
	 * @param Author:
	 *            Rodrigo
	 * @param Date:
	 *            24/03/2016
	 *            
	 * Modified by: Felipe
	 * Description: renamed method mapping to /home and ajusted it at the landing.html
	 * @return
	 * @description: method to display the articles when the user is
	 *               authenticated.
	 * 
	 */
	@RequestMapping("/home")
	public String viewArticles(Model model, HttpSession session) {
		return view(model, session);
	}
}
