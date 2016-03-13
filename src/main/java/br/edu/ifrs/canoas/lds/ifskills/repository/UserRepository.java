package br.edu.ifrs.canoas.lds.ifskills.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifrs.canoas.lds.ifskills.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);

	List<User> findAllByFullNameContainingOrEmailContainingAllIgnoreCase(String fullName, String email);
	
}