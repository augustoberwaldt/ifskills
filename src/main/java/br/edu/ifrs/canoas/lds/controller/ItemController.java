package br.edu.ifrs.canoas.lds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifrs.canoas.lds.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService service;

	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("items", service.list());
		return "/item/list";
	}

	@RequestMapping("/view/{id}")
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("item", service.get(id));
		return "/item/view";
	}
	
}