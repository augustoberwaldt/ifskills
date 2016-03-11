package br.edu.ifrs.canoas.lds.ifskills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.ifskills.domain.Item;
import br.edu.ifrs.canoas.lds.ifskills.domain.User;
import br.edu.ifrs.canoas.lds.ifskills.repository.UserRepository;


@Service
public class UserProfileService {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserProfileService(UserRepository usuarioRepository) {
		this.userRepository = usuarioRepository;
	}
	
	public Iterable<User> list(){
		return userRepository.findAll();
	}
	
	public User findByEmail(String email){
		return userRepository.findByEmail(email);
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public UserDetailsImpl getPrincipal() {
		if (SecurityContextHolder.getContext() != null 
				&& SecurityContextHolder.getContext().getAuthentication() != null 
				&& SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null)
			return  (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return null;
	}
	
	//tenativa 09/03
	public User get(Long id) {
		return userRepository.findOne(id);
	}

	public User list(String parameter) {
		return userRepository.findAllByFullNameOrEmailAllIgnoreCase(parameter,parameter);
	}

}
