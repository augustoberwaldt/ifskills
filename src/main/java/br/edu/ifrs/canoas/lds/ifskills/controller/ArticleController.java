/*
 * 
 */
package br.edu.ifrs.canoas.lds.ifskills.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.MailException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifrs.canoas.lds.ifskills.domain.Article;
import br.edu.ifrs.canoas.lds.ifskills.domain.Comment;
import br.edu.ifrs.canoas.lds.ifskills.service.ArticleService;
import br.edu.ifrs.canoas.lds.ifskills.service.NotificationService;
import br.edu.ifrs.canoas.lds.ifskills.service.UserProfileService;

// TODO: Auto-generated Javadoc
@Controller
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private NotificationService notificationService;
	
	private ArticleService articleService;
	private MessageSource messageSource;
	private UserProfileService userService;

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
	public ArticleController(ArticleService articleService, UserProfileService userService,
			MessageSource messageSource) {
		this.articleService = articleService;
		this.userService = userService;
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
	 * Author: Aline G.
	 * Date: 01/04/2016
	 * Description: Method that calls sendNotification() and delete an Article.
	 * 
	 * Modified by Aline G. 
	 * Date: 05/04/2016
	 * Now it's calling sendNotification() before delete the Article.
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
	@Secured("ROLE_ADMIN")
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model, RedirectAttributes redirectAttrs, Locale locale) {
		int not = 0;
		Article article = articleService.get(id);
			
		if (article != null) {
		 try {
			notificationService.sendNotification(article);
			}catch( MailException e){
		      not = 1;
		 }
		
		articleService.delete(id);

		redirectAttrs.addFlashAttribute("message",
				MessageFormat.format(messageSource.getMessage("article.deleted", null, locale), article.getTitle()));
		  if (not==1) {
			redirectAttrs.addFlashAttribute("message2",
					 MessageFormat.format(messageSource.getMessage("article.mail.failed", null, locale), null));
		  }

		return "redirect:/";
		} 
		
		redirectAttrs.addFlashAttribute("message3",
				MessageFormat.format(messageSource.getMessage("article.deleted.failed", null, locale),null));
		
//		if (au==1) {
//		redirectAttrs.addFlashAttribute("message4",
//				MessageFormat.format(messageSource.getMessage("article.deleted.failed2", null, locale),null));
//	    }
		return "redirect:/";
	}

	/**
	 * Author: Felipe
	 * Date: 03/04/2016
	 * Creates the.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping("/new")
	public String create(Model model) {
		model.addAttribute("article", new Article());
		model.addAttribute("author", userService.list());
		model.addAttribute("readonly", false);
		return "/article/new";
	}

	/**
	 * Author: Felipe
	 * Date: 03/04/2016
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
		model.addAttribute("users", userService.list());
		model.addAttribute("readonly", false);
		return "/article/new";
	}

	/**
	 * Author: Felipe
	 * Date: 03/04/2016
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
			@RequestParam("articlePicture") MultipartFile picture,
			RedirectAttributes redirectAttrs, Locale locale) throws IOException{
		
		if (!bindingResult.hasErrors()) {
			article.setAuthor(userService.getPrincipal().getUser());			
			article.setPostedOn(new Timestamp(System.currentTimeMillis()));
			article.setActive(true);
			article.setPicture(picture.getBytes());
			String slug = article.getTeaser();
			slug.substring(0,slug.length());
			slug.replaceAll(" ", "-");
			article.setSlug(slug);
			Article savedArticle = articleService.save(article);
			redirectAttrs.addFlashAttribute("message", messageSource.getMessage("article.saved", null, locale));
			return "redirect:/";
		}
		model.addAttribute("readonly", false);
		return "redirect:/article/new";
	}

	/**
	 * Author: Luciane
	 * Date: 24/03/2016
	 * Description: Change view to read by @RequestMapping("/view/{slug}").
	 * @param model
	 * @return
	 */
	@RequestMapping("/view/{slug}") 
	public String view(@PathVariable String slug, Model model) {
		Article article = articleService.get(slug);
		Comment comment = new Comment();
		comment.setArticle(article);
		
		model.addAttribute("auth",userService.getPrincipal() != null );
		model.addAttribute("article",  article);
		model.addAttribute("comment",  comment);
		return "/article/view";
	}

	@RequestMapping("/viewAuth")
	public String viewAuth(Model model) {
		model.addAttribute("auth", userService.getPrincipal() != null);
		return "/article/view";
	}
	
	/**
	 * 01/04/16 - Ricardo - Create method showArticleList
	 * 
	 * @param model
	 * @param req
	 * @param locale
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String showArticleList(Model model, final HttpServletRequest req, final Locale locale) {
		String criteria = req.getParameter("criteria");
		if (criteria != null && !criteria.isEmpty()) {
			List<Article> articles = articleService.list(criteria);
			if (articles.isEmpty()) {
				model.addAttribute("message",
						messageSource.getMessage("article.notFound", null, locale));
			}
			model.addAttribute("articles", articles);
		} else if (criteria != null && criteria.isEmpty()) {
			model.addAttribute("articles", new ArrayList<Article>());
			model.addAttribute("message", messageSource.getMessage("article.validatorCriteria", null, locale));
		}
		return "/article/list";
	}
	
}
