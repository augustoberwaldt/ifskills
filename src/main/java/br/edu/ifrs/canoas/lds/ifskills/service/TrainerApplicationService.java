/**
 * @author: Fernando Sturzbecher
 * @date: 31/03/2016
 * @description: This is the service class for TrainerApplication
 */
package br.edu.ifrs.canoas.lds.ifskills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.ifskills.domain.TrainerApplication;
import br.edu.ifrs.canoas.lds.ifskills.repository.TrainerApplicationRepository;

// TODO: Auto-generated Javadoc
@Service
public class TrainerApplicationService {

	private TrainerApplicationRepository trainerApplicationRepository;

	/**
	 * Instantiates a new trainer application service.
	 *
	 * @param repo
	 *            the trainer application repository
	 */
	@Autowired
	public TrainerApplicationService(TrainerApplicationRepository trainerApplicationRepository) {
		this.trainerApplicationRepository = trainerApplicationRepository;
	}

	/**
	 * List.
	 *
	 * @return the iterable
	 */
	public Iterable<TrainerApplication> list() {
		return trainerApplicationRepository.findAll();
	}

	/**
	 * Gets the.
	 *
	 * @param id
	 *            the id
	 * @return the trainer application
	 */
	public TrainerApplication get(Long id) {
		return trainerApplicationRepository.findOne(id);
	}

	/**
	 * Save.
	 *
	 * @param trainer applications
	 *            the trainer application
	 * @return the trainer application
	 */
	public TrainerApplication save(TrainerApplication trainerApplications) {
		return trainerApplicationRepository.save(trainerApplications);
	}

	/**
	 * Delete.
	 *
	 * @param id
	 *            the id
	 */
	public void delete(Long id) {
		trainerApplicationRepository.delete(id);
	}

}