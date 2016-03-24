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

import br.edu.ifrs.canoas.lds.ifskills.domain.Item;
import br.edu.ifrs.canoas.lds.ifskills.service.ItemService;

// TODO: Auto-generated Javadoc
@Controller
@RequestMapping("/item")
public class ItemController {

	private ItemService itemService;
	private MessageSource messageSource;

	/**
	 * Instantiates a new item controller.
	 *
	 * @param service
	 *            the service
	 * @param messageSource
	 *            the message source
	 */
	@Autowired
	public ItemController(ItemService service, MessageSource messageSource) {
		this.itemService = service;
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
		model.addAttribute("items", itemService.list());
		return "/item/list";
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
		model.addAttribute("item", new Item());
		model.addAttribute("readonly", false);
		return "/item/form";
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
		model.addAttribute("item", itemService.get(id));
		model.addAttribute("readonly", true);
		return "/item/form";
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
		model.addAttribute("item", itemService.get(id));
		model.addAttribute("readonly", false);
		return "/item/form";
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
		Item item = itemService.get(id);
		if (item != null) {
			itemService.delete(id);

			redirectAttrs.addFlashAttribute("message",
					MessageFormat.format(messageSource.getMessage("item.deleted", null, locale), item.getName()));

			return "redirect:/item/list";
		}
		model.addAttribute("message",
				MessageFormat.format(messageSource.getMessage("item.deleted.failed", null, locale), id));
		return "/item/form";
	}

	/**
	 * Save.
	 *
	 * @param item
	 *            the item
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
	public String save(@Valid Item item, BindingResult bindingResult, Model model, RedirectAttributes redirectAttrs,
			Locale locale) {
		if (!bindingResult.hasErrors()) {
			Item savedItem = itemService.save(item);
			redirectAttrs.addFlashAttribute("message", messageSource.getMessage("item.saved", null, locale));
			return "redirect:/item/view/" + savedItem.getId() + "?success";
		}
		model.addAttribute("readonly", false);
		return "/item/form";
	}

}