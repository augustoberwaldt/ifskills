package br.edu.ifrs.canoas.lds.ifskills.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import br.edu.ifrs.canoas.lds.ifskills.domain.Class;


public interface ClassRepository extends CrudRepository<Class, Long>{
	//para listar os Cursos apenas.
	@Query("SELECT i FROM Class i WHERE i.type=1")
	List<Class> findChecked();

}
