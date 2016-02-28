package br.edu.ifrs.canoas.lds.ifskills.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.edu.ifrs.canoas.lds.ifskills.domain.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {
	
	@Query("SELECT i FROM Item i WHERE i.active=true")
	List<Item> findChecked();

}
