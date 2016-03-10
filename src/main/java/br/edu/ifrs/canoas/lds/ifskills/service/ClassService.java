package br.edu.ifrs.canoas.lds.ifskills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.ifskills.domain.Class;
import br.edu.ifrs.canoas.lds.ifskills.repository.ClassRepository;

@Service
public class ClassService {

	private ClassRepository classRepository;
	
	@Autowired
	public ClassService(ClassRepository repo) {
		this.classRepository = repo;
	}
	
	public Iterable<Class> list() {
		return classRepository.findAll();
	}

	public Class get(Long id) {
		return classRepository.findOne(id);
	}

	public Class save(Class classes) {
		return classRepository.save(classes);
	}

	public void delete(Long id) {
		classRepository.delete(id);
	}

}