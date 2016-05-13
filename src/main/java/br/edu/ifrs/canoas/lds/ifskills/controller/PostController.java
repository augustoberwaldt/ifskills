package br.edu.ifrs.canoas.lds.ifskills.controller;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifrs.canoas.lds.ifskills.domain.Post;
import br.edu.ifrs.canoas.lds.ifskills.domain.User;
import br.edu.ifrs.canoas.lds.ifskills.service.PostService;
import br.edu.ifrs.canoas.lds.ifskills.service.UserProfileService;

/**
 * 01/05/16 - Ricardo - PostController /post
 */
@Controller
@RequestMapping("/post")
public class PostController {

	/**
	 * 01/05/16 - Ricardo
	 */
	private PostService postService;
	private UserProfileService userProfileService;
	private MessageSource messageSource;
	
	
	/**
	 * 01/05/16 - Ricardo - Instantiates a new post controller
	 * @param postService
	 * @param userService
	 * @param messageSource
	 */
	@Autowired
	public PostController(PostService postService, MessageSource messageSource, UserProfileService userProfileService) {
		this.postService = postService;
		this.messageSource = messageSource;
		this.userProfileService = userProfileService;
	}
	
	/**
	 * 01/05/16 - Ricardo - /list
	 * 05/05/16 - Ricardo - post to posts in model.addAttribute
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("posts", postService.list());
		return "/post/list";
	}
	
	/**
	 * 01/05/16 - Ricardo - /create
	 * @param model
	 * @return
	 */
	@RequestMapping("/create")
	public String create(Model model) {
		model.addAttribute("post", new Post());
		model.addAttribute("readonly", false);
		//model.addAttribute("userList", findResponsibles());
		return "/post/form";
	}
	
	/**
	 * 01/05/16 - Ricardo - /view
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/view/{id}")
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("post", postService.get(id));
		model.addAttribute("readonly", true);
		return "/post/form";
	}
	
	/**
	 * 01/05/16 - Ricardo - /edit
	 * 
	 * Modified by Luciane
	 * Date: 09/05/2016
	 * Description: Add security check
	 */
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@RequestMapping("/edit/{id}")
	public String update(@PathVariable Long id, Model model) {
		model.addAttribute("post", postService.get(id));
		model.addAttribute("readonly", false);
		return "/post/form";
	}
	
	/**
	 * 01/05/16 - Ricardo - /delete
	 * 
	 * Modified by Luciane
	 * Date: 09/05/2016
	 * Description: Add security check
	 */
	
	@Secured({"ROLE_USER","ROLE_ADMIN"})
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model, RedirectAttributes redirectAttrs, Locale locale) {
		Post post = postService.get(id);
		if (post != null) {
			postService.delete(id);

			redirectAttrs.addFlashAttribute("message",
					MessageFormat.format(messageSource.getMessage("post.deleted", null, locale), post.getTitle()));
			return "redirect:/post/list";
		}
		model.addAttribute("message",
				MessageFormat.format(messageSource.getMessage("post.deleted.failed", null, locale), id));
		return "/post/form";
	}
	
	/**
	 * 01/05/16 - Ricardo - /save
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Post post, BindingResult bindingResult, Model model, RedirectAttributes redirectAttrs,
			Locale locale) {
		if (!bindingResult.hasErrors()) {
			if(!post.getIsPublic())
				post.setIsPublic(false);
			
			Post savedPost = postService.save(post);
			redirectAttrs.addFlashAttribute("message", messageSource.getMessage("post.saved", null, locale));
			return "redirect:/post/view/" + savedPost.getId() + "?success";
		}
		model.addAttribute("readonly", false);
		return "/post/form";
	}
	
	/**
	 * @author Luciane
	 * @date: 12/05/2016
	 * @description: Populate list responsibles
	 * @param id
	 * @param model
	 * @return
	 */
	/*private List<String> findResponsibles() {
		Iterable<User> responsibles = userProfileService.list();
		List<String> nomes = new ArrayList<>();
		for (User user : responsibles) {
			nomes.add(user.getFullName());
		}
		return nomes;
	}
	
	@RequestMapping(value = "users", method = RequestMethod.GET)
    public String users(Model model) {
            model.addAttribute("users",  findResponsibles());
            return "/post/form";
    }*/
}