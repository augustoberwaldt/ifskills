package br.edu.ifrs.canoas.lds.ifskills.controller;

import java.text.MessageFormat;
import java.util.Locale;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.edu.ifrs.canoas.lds.ifskills.domain.Post;
import br.edu.ifrs.canoas.lds.ifskills.service.PostService;

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
	private MessageSource messageSource;
	
	/**
	 * 01/05/16 - Ricardo - Instantiates a new post controller
	 * @param postService
	 * @param userService
	 * @param messageSource
	 */
	@Autowired
	public PostController(PostService postService, MessageSource messageSource) {
		this.postService = postService;
		this.messageSource = messageSource;
	}
	
	/**
	 * 01/05/16 - Ricardo - /list
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("post", postService.list());
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
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit/{id}")
	public String update(@PathVariable Long id, Model model) {
		model.addAttribute("post", postService.get(id));
		model.addAttribute("readonly", false);
		return "/post/form";
	}
	
	/**
	 * 01/05/16 - Ricardo - /delete
	 * @param id
	 * @param model
	 * @param redirectAttrs
	 * @param locale
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model, RedirectAttributes redirectAttrs, Locale locale) {
		Post post = postService.get(id);
		if (post != null) {
			postService.delete(id);

			redirectAttrs.addFlashAttribute("message",
					MessageFormat.format(messageSource.getMessage("post.deleted", null, locale), post.getBody()));
			return "redirect:/post/list";
		}
		model.addAttribute("message",
				MessageFormat.format(messageSource.getMessage("post.deleted.failed", null, locale), id));
		return "/post/form";
	}
	
	/**
	 * 01/05/16 - Ricardo - /save
	 * @param post
	 * @param bindingResult
	 * @param model
	 * @param redirectAttrs
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Post post, BindingResult bindingResult, Model model, RedirectAttributes redirectAttrs,
			Locale locale) {
		if (!bindingResult.hasErrors()) {
			Post savedPost = postService.save(post);
			redirectAttrs.addFlashAttribute("message", messageSource.getMessage("post.saved", null, locale));
			return "redirect:/post/view/" + savedPost.getId() + "?success";
		}
		model.addAttribute("readonly", false);
		return "/post/form";
	}

}