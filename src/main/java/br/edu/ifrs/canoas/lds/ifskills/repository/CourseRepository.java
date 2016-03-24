/**
 * @author:
 * @date: 
 * @description: 
 */
package br.edu.ifrs.canoas.lds.ifskills.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifrs.canoas.lds.ifskills.domain.Course;


public interface CourseRepository extends CrudRepository<Course, Long>{
	//para listar os Cursos apenas.
	
	//List<Course> findClassByType_TypeName(String typeName);

}
