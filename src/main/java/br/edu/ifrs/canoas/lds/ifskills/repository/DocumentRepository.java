package br.edu.ifrs.canoas.lds.ifskills.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifrs.canoas.lds.ifskills.domain.Document;
/**
 * 
 * @author Felipe
 * Date: 11/05/2016
 * 
 **/
public interface DocumentRepository extends CrudRepository<Document, Long> {
	

}
