/**
 * @author:
 * @date: 
 * @description: 
 */
package br.edu.ifrs.canoas.lds.ifskills.controller;

import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	 * Description: Instantiates a new article comment.
	 *
	 * @param commentService
	 *            the comment service
	 * @param userProfileService
	 *            the user profile service
	 * @param messageSource
	 *            the message source
	 */
	@Autowired
	public CommentController(CommentService commentService, 
			MessageSource messageSource, UserProfileService userService
			,ArticleService articleService) {
		this.commentService = commentService;
		this.messageSource = messageSource;
		this.userService = userService;
		this.articleService=articleService;
	}
	
	
	
	/**
	 * Author: Luciane 
	 * Date: 27/03/2016
	 * Description: Method of the save a new article comment.
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
	
	public void delete(Comment comment){
		if (comment.getAuthor().getId() != userService.getPrincipal().getUser().getId());
	}
	
	
	

}
