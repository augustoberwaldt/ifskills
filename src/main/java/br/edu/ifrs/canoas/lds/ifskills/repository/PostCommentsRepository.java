package br.edu.ifrs.canoas.lds.ifskills.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import br.edu.ifrs.canoas.lds.ifskills.domain.PostComments;

/**
 * May/09/16 - Edward - PostCommentsRepository extends CrudRepository
 */
public interface PostCommentsRepository extends CrudRepository<PostComments, Long> {
	
	/**
	 * May/09/16 - Edward - Find checked
	 * @return
	 */
	@Query("SELECT i FROM PostComments i WHERE i.hidden=false")
	List<PostComments> findChecked();

}