/**
 * @author:
 * @date: 
 * @description: 
 */
package br.edu.ifrs.canoas.lds.ifskills.service;

import br.edu.ifrs.canoas.lds.ifskills.domain.User;

public interface UserService {

	/**
	 * Find by email.
	 *
	 * @param email
	 *            the email
	 * @return the user
	 */	
	public User findByEmail(String email);
	
	

}
