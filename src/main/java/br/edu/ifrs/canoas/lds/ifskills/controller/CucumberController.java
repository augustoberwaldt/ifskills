/**
 * @author:
 * @date: 
 * @description: 
 */
package br.edu.ifrs.canoas.lds.ifskills.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CucumberController {

	/**
	 * Cucumber.
	 *
	 * @return the string
	 */
	@RequestMapping(method={RequestMethod.GET},value={"/cucumber"})
	public String cucumber(){
		return "Success";
	}
	
}
