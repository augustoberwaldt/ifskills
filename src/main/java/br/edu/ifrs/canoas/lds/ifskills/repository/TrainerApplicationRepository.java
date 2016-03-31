/**
 * @author: Fernando
 * @date: 31/03/2016
 * @description: This class is used to search applications on DB.
 */
package br.edu.ifrs.canoas.lds.ifskills.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifrs.canoas.lds.ifskills.domain.TrainerApplication;

public interface TrainerApplicationRepository extends CrudRepository<TrainerApplication, Long> {
}
