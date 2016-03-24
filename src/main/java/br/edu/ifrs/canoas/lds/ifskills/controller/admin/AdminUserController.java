/**
 * @author:
 * @date: 
 * @description: 
 */
package br.edu.ifrs.canoas.lds.ifskills.controller.admin;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Secured({ "ROLE_ADMIN" })
@RequestMapping("/admin/user")
public class AdminUserController {

	/**
	 * View.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping("/view")
	@ResponseBody
	public String view(Model model) {
		return "Authorized user to acess something!";
	}

}
