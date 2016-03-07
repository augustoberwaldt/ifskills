package br.edu.ifrs.canoas.lds.ifskills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.ifskills.domain.User;
import br.edu.ifrs.canoas.lds.ifskills.repository.UserRepository;

@Service
public class ManageUserService {
	
	private UserRepository repo;
	
	@Autowired
	public ManageUserService(UserRepository usuarioRepository) {
		this.repo = usuarioRepository;
	}
	
	public Iterable<User> list(){
		return repo.findAll();
	}
	
	public User findByEmail(String email){
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
