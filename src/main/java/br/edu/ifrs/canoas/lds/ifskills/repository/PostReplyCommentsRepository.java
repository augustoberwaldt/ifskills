package br.edu.ifrs.canoas.lds.ifskills.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import br.edu.ifrs.canoas.lds.ifskills.domain.PostReplyComments;

/**
 * May/09/16 - Edward - PostReplyCommentsRepository extends CrudRepository
 */
public interface PostReplyCommentsRepository extends CrudRepository<PostReplyComments, Long> {
	
	/**
	 * May/09/16 - Edward - Find checked
	 * @return
	 */
	//@Query("SELECT i FROM PostReplyComments i WHERE i.hidden=false")
	//List<PostReplyComments> findChecked();

}