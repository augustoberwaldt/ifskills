/*
 * 
 */
package br.edu.ifrs.canoas.lds.ifskills.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifrs.canoas.lds.ifskills.service.JobAdService;
import br.edu.ifrs.canoas.lds.ifskills.service.UserProfileService;

// TODO: Auto-generated Javadoc
@Controller
@RequestMapping("/jobAd")
public class JobAdController {

	@Autowired
	private JobAdService jobadService;
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
	public JobAdController(JobAdService jobadService, UserProfileService userService,
			MessageSource messageSource) {
		this.jobadService = jobadService;
		this.userService = userService;
		this.messageSource = messageSource;
	}

	
}
