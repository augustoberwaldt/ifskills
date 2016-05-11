/**
 * @author:
 * @date: 
 * @description: 
 */
package br.edu.ifrs.canoas.lds.ifskills.controller;

import java.text.MessageFormat;
import java.util.Date;
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
import br.edu.ifrs.canoas.lds.ifskills.domain.Comment;
import br.edu.ifrs.canoas.lds.ifskills.service.ArticleService;
import br.edu.ifrs.canoas.lds.ifskills.service.CommentService;
import br.edu.ifrs.canoas.lds.ifskills.service.UserProfileService;

//TODO: Auto-generated Javadoc
@Controller
@RequestMapping("/article/comment")
public class CommentController {

	private CommentService commentService;
	private MessageSource messageSource;
	private UserProfileService userService;
	private ArticleService articleService;

	/**
	 * Author: Luciane 
	 * Date: 27/03/2016 
	 * Description: Instantiates a new article
	 * comment.
	 *
	 * @param commentService
	 *            the comment service
	 * @param userProfileService
	 *            the user profile service
	 * @param messageSource
	 *            the message source
	 */
	@Autowired
	public CommentController(CommentService commentService, MessageSource messageSource, UserProfileService userService,
			ArticleService articleService) {
		this.commentService = commentService;
		this.messageSource = messageSource;
		this.userService = userService;
		this.articleService = articleService;
	}

	/**
	 * Author: Luciane 
	 * Date: 27/03/2016 
	 * Description: Method of the save a new
	 * article comment.
	 * 
	 * @param comment
	 *            the comment
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
	public String save(@Valid Comment comment, BindingResult bindingResult, Model model, RedirectAttributes redirectAttrs,
			Locale locale) {
		if (!bindingResult.hasErrors()) {
			
			comment.setAuthor(userService.getPrincipal().getUser());
			comment.setPostedOn(new Date());
			Article article = articleService.get(comment.getArticle().getId());
			
			comment.setArticle(article);
			article.getComments().add(comment);
			
			commentService.save(comment);
			articleService.save(comment.getArticle());
			
			return "redirect:/article/view/" + comment.getArticle().getSlug();
		}
		return "redirect:/article/view/"+comment.getArticle().getSlug();
	}


	/**
	 * Author: Luciane 
	 * Date: 28/03/2016 
	 * Description: Method that allows the
	 * deletion of an article that is saved in the database . 
	 * 
	 * Delete.
	 *
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 * @param redirectAttrs
	 *            the redirect attrs
	 * @param locale
	 *            the locale
	 * @return the string
	 */
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model, RedirectAttributes redirectAttrs, Locale locale) {
		Comment comment = commentService.get(id);
		if (comment.getAuthor().getId() != userService.getPrincipal().getUser().getId()){
			model.addAttribute("message",
					MessageFormat.format(messageSource.getMessage("comment.deleted.failed", null, locale), id));
			return "redirect:/article/view/"+comment.getArticle().getSlug();
		}else		
			commentService.delete(id);

		redirectAttrs.addFlashAttribute("message", MessageFormat
				.format(messageSource.getMessage("comment.deleted", null, locale), comment.getContent()));

		return "redirect:/article/view/"+comment.getArticle().getSlug();

	}
	
	/**
	 * Create - 11/05/16 - Ricardo - /list
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("comment", commentService.list());
		return "/comment/list";
	}

}
