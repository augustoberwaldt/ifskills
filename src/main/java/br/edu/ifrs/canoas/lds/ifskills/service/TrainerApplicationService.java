/**
 * @author:
 * @date: 
 * @description: 
 */
package br.edu.ifrs.canoas.lds.ifskills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.ifskills.domain.Course;
import br.edu.ifrs.canoas.lds.ifskills.repository.CourseRepository;

// TODO: Auto-generated Javadoc
@Service
public class TrainerApplicationService {

	private CourseRepository courseRepository;
	
	/**
	 * Instantiates a new course service.
	 *
	 * @param repo
	 *            the repo
	 */
	@Autowired
	public TrainerApplicationService(CourseRepository repo) {
		this.courseRepository = repo;
	}
	
	/**
	 * List.
	 *
	 * @return the iterable
	 */
	public Iterable<Course> list() {
		return courseRepository.findAll();
	}

	/**
	 * Gets the.
	 *
	 * @param id
	 *            the id
	 * @return the course
	 */
	public Course get(Long id) {
		return courseRepository.findOne(id);
	}

	/**
	 * Save.
	 *
	 * @param courses
	 *            the courses
	 * @return the course
	 */
	public Course save(Course courses) {
		return courseRepository.save(courses);
	}

	/**
	 * Delete.
	 *
	 * @param id
	 *            the id
	 */
	public void delete(Long id) {
		courseRepository.delete(id);
	}

}