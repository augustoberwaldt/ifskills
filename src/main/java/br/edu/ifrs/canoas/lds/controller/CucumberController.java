package br.edu.ifrs.canoas.lds.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CucumberController {

	@RequestMapping(method={RequestMethod.GET},value={"/cucumber"})
	public String cucumber(){
		return "Success";
	}
}
