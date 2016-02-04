package br.edu.ifrs.canoas.lds.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifrs.canoas.lds.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);
	
}
