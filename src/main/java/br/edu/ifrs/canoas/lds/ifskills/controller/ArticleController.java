/*
 * 
 */
package br.edu.ifrs.canoas.lds.ifskills.controller;

import java.text.MessageFormat;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifrs.canoas.lds.ifskills.domain.Article;
import br.edu.ifrs.canoas.lds.ifskills.service.ArticleService;
import br.edu.ifrs.canoas.lds.ifskills.service.UserProfileService;

public class ArticleController {
	
	private ArticleService articleService;
	private MessageSource messageSource;
	private UserProfileService userProfileService;

	@Autowired
	public ArticleController(ArticleService articleService, UserProfileService userProfileService, MessageSource messageSource) {
		this.articleService = articleService;
		this.userProfileService = userProfileService;
		this.messageSource = messageSource;
	}

	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("article", articleService.list());
		return "/article/list";
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @param redirectAttrs
	 * @param locale
	 * @return
	 * @author Luciane
	 * @
	 */
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model, RedirectAttributes redirectAttrs, Locale locale) {
		Article article = articleService.get(id);
		articleService.delete(id);

		redirectAttrs.addFlashAttribute("message",
				MessageFormat.format(messageSource.getMessage("article.deleted", null, locale), article.getTitle()));

		return "redirect:/index";
	}

	@RequestMapping("/create")
	public String create(Model model) {
		model.addAttribute("article", new Article());
		model.addAttribute("trainers", userProfileService.findAllTrainers());
		model.addAttribute("readonly", false);
		return "/course/form";
	}

	@RequestMapping("/view/{id}")
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("article", articleService.get(id));
		model.addAttribute("users", userProfileService.list());
		model.addAttribute("readonly", true);
		return "/course/form";
	}

	@RequestMapping("/edit/{id}")
	public String update(@PathVariable Long id, Model model) {
		model.addAttribute("article", articleService.get(id));
		model.addAttribute("users", userProfileService.list());
		model.addAttribute("readonly", false);
		return "/course/form";
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Article article, BindingResult bindingResult, Model model, RedirectAttributes redirectAttrs,
			Locale locale) {
		if (!bindingResult.hasErrors()) {
			Article savedArticle = articleService.save(article);
			model.addAttribute("readonly", true);

			redirectAttrs.addFlashAttribute("message", messageSource.getMessage("article.saved", null, locale));

			return "redirect:/article/view/" + savedArticle.getId() + "?success";
		}
		model.addAttribute("readonly", false);
		return "/index";
	}
}
