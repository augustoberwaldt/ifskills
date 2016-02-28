package br.edu.ifrs.canoas.lds.ifskills.service;

import br.edu.ifrs.canoas.lds.ifskills.domain.User;

public interface UserService {

	public User findByEmail(String email);
	
}
