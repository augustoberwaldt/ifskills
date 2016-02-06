package br.edu.ifrs.canoas.lds.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifrs.canoas.lds.domain.Item;
import br.edu.ifrs.canoas.lds.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

	private ItemService itemService;

	@Autowired
	public ItemController(ItemService service) {
		this.itemService = service;
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("items", itemService.list());
		return "/item/list";
	}
	
	@RequestMapping("/create")
	public String create(Model model) {
		model.addAttribute("item", new Item());
		model.addAttribute("readonly", false);
		return "/item/form";
	}

	@RequestMapping("/view/{id}")
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("item", itemService.get(id));
		model.addAttribute("readonly", true);
		return "/item/form";
	}

	@RequestMapping("/edit/{id}")
	public String update(@PathVariable Long id, Model model) {
		model.addAttribute("item", itemService.get(id));
		model.addAttribute("readonly", false);
		return "/item/form";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		Item item = itemService.get(id);
		itemService.delete(id);
		return "redirect:/item/list?delete="+item.getName();
	}
	

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid Item item, BindingResult bindingResult, Model model) {
		if(!bindingResult.hasErrors() ){
			Item savedItem = itemService.save(item);
			model.addAttribute("readonly", true);
			return "redirect:/item/view/" + savedItem.getId()+"?success";		
		}
		model.addAttribute("readonly", false);
		return "/item/form";
	}
	
	
}