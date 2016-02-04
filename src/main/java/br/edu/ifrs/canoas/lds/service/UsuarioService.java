package br.edu.ifrs.canoas.lds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.domain.User;
import br.edu.ifrs.canoas.lds.repository.UserRepository;

@Service
public class UsuarioService {
	
	private UserRepository repo;
	
	@Autowired
	public UsuarioService(UserRepository usuarioRepository) {
		this.repo = usuarioRepository;
	}
	
	public Iterable<User> lista(){
		return repo.findAll();
	}
	
	public User buscaPorEmail(String email){
		return repo.findByEmail(email);
	}

	public User save(User user) {
		return repo.save(user);
	}

	public UserDetailsImpl getPrincipal() {
		if (SecurityContextHolder.getContext() != null 
				&& SecurityContextHolder.getContext().getAuthentication() != null 
				&& SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null)
			return  (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return null;
	}

}
