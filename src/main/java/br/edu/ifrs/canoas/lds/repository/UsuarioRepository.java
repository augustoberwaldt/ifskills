package br.edu.ifrs.canoas.lds.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifrs.canoas.lds.domain.User;

public interface UsuarioRepository extends CrudRepository<User, Long>{

}
