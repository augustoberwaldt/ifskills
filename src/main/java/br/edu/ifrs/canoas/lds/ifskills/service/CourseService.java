package br.edu.ifrs.canoas.lds.ifskills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.ifskills.domain.Course;
import br.edu.ifrs.canoas.lds.ifskills.repository.CourseRepository;

@Service
public class CourseService {

	private CourseRepository courseRepository;
	
	@Autowired
	public CourseService(CourseRepository repo) {
		this.courseRepository = repo;
	}
	
	public Iterable<Course> list() {
		return courseRepository.findAll();
	}

	public Course get(Long id) {
		return courseRepository.findOne(id);
	}

	public Course save(Course courses) {
		return courseRepository.save(courses);
	}

	public void delete(Long id) {
		courseRepository.delete(id);
	}

}