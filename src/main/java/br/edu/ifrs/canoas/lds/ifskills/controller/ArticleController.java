/*
 * 
 */
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

import br.edu.ifrs.canoas.lds.ifskills.domain.Article;
import br.edu.ifrs.canoas.lds.ifskills.service.ArticleService;
import br.edu.ifrs.canoas.lds.ifskills.service.UserProfileService;

// TODO: Auto-generated Javadoc
@Controller
@RequestMapping("/article")
public class ArticleController {

	private ArticleService articleService;
	private MessageSource messageSource;
	private UserProfileService userProfileService;

	/**
	 * Instantiates a new article controller.
	 *
	 * @param articleService
	 *            the article service
	 * @param userProfileService
	 *            the user profile service
	 * @param messageSource
	 *            the message source
	 */
	@Autowired
	public ArticleController(ArticleService articleService, UserProfileService userProfileService,
			MessageSource messageSource) {
		this.articleService = articleService;
		this.userProfileService = userProfileService;
		this.messageSource = messageSource;
	}

	/**
	 * List.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("article", articleService.list());
		return "/article/list";
	}

	/**
	 * Delete.
	 *
	 * @author Luciane
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 * @param redirectAttrs
	 *            the redirect attrs
	 * @param locale
	 *            the locale
	 * @return the string @
	 */
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model, RedirectAttributes redirectAttrs, Locale locale) {
		Article article = articleService.get(id);
		articleService.delete(id);

		redirectAttrs.addFlashAttribute("message",
				MessageFormat.format(messageSource.getMessage("article.deleted", null, locale), article.getTitle()));

		return "redirect:/index";
	}

	/**
	 * Creates the.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping("/create")
	public String create(Model model) {
		model.addAttribute("article", new Article());
		model.addAttribute("trainers", userProfileService.findAllTrainers());
		model.addAttribute("readonly", false);
		return "/article/newarticle";
	}

	/**
	 * View.
	 *
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping("/view/{id}")
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("article", articleService.get(id));
		model.addAttribute("users", userProfileService.list());
		model.addAttribute("readonly", true);
		return "/article/form";
	}

	/**
	 * Update.
	 *
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping("/edit/{id}")
	public String update(@PathVariable Long id, Model model) {
		model.addAttribute("article", articleService.get(id));
		model.addAttribute("users", userProfileService.list());
		model.addAttribute("readonly", false);
		return "/article/form";
	}

	/**
	 * Save.
	 *
	 * @param article
	 *            the article
	 * @param bindingResult
	 *            the binding result
	 * @param model
	 *            the model
	 * @param redirectAttrs
	 *            the redirect attrs
	 * @param locale
	 *            the locale
	 * @return the string
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Article article, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttrs, Locale locale) {
		if (!bindingResult.hasErrors()) {
			Article savedArticle = articleService.save(article);
			model.addAttribute("readonly", true);

			redirectAttrs.addFlashAttribute("message", messageSource.getMessage("article.saved", null, locale));

			return "redirect:/article/view/" + savedArticle.getId() + "?success";
		}
		model.addAttribute("readonly", false);
		return "/index";
	}

	/**
	 * Author: Luciane Date: 24/03/2016 Description: Change view to read
	 * by @RequestMapping("/view/{slug}").
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/view")
	public String view(Model model) {
		model.addAttribute("auth", userProfileService.getPrincipal() != null);
		return "/article/view";
	}

	@RequestMapping("/viewAuth")
	public String viewAuth(Model model) {
		model.addAttribute("auth", userProfileService.getPrincipal() != null);
		return "/article/view";
	}
}
