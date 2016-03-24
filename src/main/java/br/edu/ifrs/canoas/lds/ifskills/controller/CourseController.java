/**
 * @author:
 * @date: 
 * @description: 
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

import br.edu.ifrs.canoas.lds.ifskills.domain.Course;
import br.edu.ifrs.canoas.lds.ifskills.service.CourseService;
import br.edu.ifrs.canoas.lds.ifskills.service.UserProfileService;

// TODO: Auto-generated Javadoc
@Controller
@RequestMapping("/course")
public class CourseController {

	private CourseService courseService;
	private UserProfileService userProfileService;
	private MessageSource messageSource;

	/**
	 * Instantiates a new course controller.
	 *
	 * @param courseService
	 *            the course service
	 * @param userProfileService
	 *            the user profile service
	 * @param messageSource
	 *            the message source
	 */
	@Autowired
	public CourseController(CourseService courseService, UserProfileService userProfileService, MessageSource messageSource) {
		this.courseService = courseService;
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
		model.addAttribute("courses", courseService.list());
		return "/course/list";
	}

	/**
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
		Course course = courseService.get(id);
		courseService.delete(id);

		redirectAttrs.addFlashAttribute("message",
				MessageFormat.format(messageSource.getMessage("course.deleted", null, locale), course.getName()));

		return "redirect:/course/list";
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
		model.addAttribute("course", new Course());
		model.addAttribute("trainers", userProfileService.findAllTrainers());
		model.addAttribute("readonly", false);
		return "/course/form";
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
		model.addAttribute("course", courseService.get(id));
		model.addAttribute("trainers", userProfileService.findAllTrainers());
		model.addAttribute("readonly", true);
		return "/course/form";
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
		model.addAttribute("course", courseService.get(id));
		model.addAttribute("trainers", userProfileService.findAllTrainers());
		model.addAttribute("readonly", false);
		return "/course/form";
	}

	/**
	 * Save.
	 *
	 * @param course
	 *            the course
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
	public String save(@Valid Course course, BindingResult bindingResult, Model model, RedirectAttributes redirectAttrs,
			Locale locale) {
		if (!bindingResult.hasErrors()) {
			Course savedCourse = courseService.save(course);
			model.addAttribute("readonly", true);

			redirectAttrs.addFlashAttribute("message", messageSource.getMessage("course.saved", null, locale));

			return "redirect:/course/view/" + savedCourse.getId() + "?success";
		}
		model.addAttribute("readonly", false);
		return "/course/form";
	}

}
