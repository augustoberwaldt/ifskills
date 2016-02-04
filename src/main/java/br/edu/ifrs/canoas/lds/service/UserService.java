package br.edu.ifrs.canoas.lds.service;

import br.edu.ifrs.canoas.lds.domain.User;

public interface UserService {

	public User findByEmail(String email);
	
}
