package br.edu.ifrs.canoas.lds.ifskills.controller.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/class")
public class ClassController {

		@Autowired
		public ClassController() {
		}
		
		/*@RequestMapping("/list")
		public String list(Model model) {
			model.addAttribute("items", itemService.list());
			return "/item/list";
		}
		
		@RequestMapping("/create")
		public String create(Model model) {
			model.addAttribute("class", new Class());
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
		public String delete(@PathVariable Long id, Model model, RedirectAttributes redirectAttrs, Locale locale) {
			Item item = itemService.get(id);
			itemService.delete(id);
			
			redirectAttrs.addFlashAttribute("message", 
					MessageFormat.format(messageSource.getMessage("item.deleted", null, locale), 
							item.getName()));
			
			return "redirect:/item/list";
		}	

		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String save(@Valid Item item, BindingResult bindingResult, Model model, RedirectAttributes redirectAttrs, Locale locale) {
			if(!bindingResult.hasErrors() ){
				Item savedItem = itemService.save(item);
				model.addAttribute("readonly", true);
				
				redirectAttrs.addFlashAttribute("message", messageSource.getMessage("item.saved", null, locale));
				
				return "redirect:/item/view/" + savedItem.getId()+"?success";		
			}
			model.addAttribute("readonly", false);
			return "/item/form";
		}*/	
		
}
