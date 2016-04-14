/**
 * @author:
 * @date: 
 * @description: 
 */
package br.edu.ifrs.canoas.lds.ifskills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.ifskills.repository.JobAdRepository;

// TODO: Auto-generated Javadoc
@Service
public class JobAdService {

	private JobAdRepository JobAdRepository;

	/**
	 * Instantiates a new article service.
	 *
	 * @param artRepo
	 *            the art repo
	 */
	@Autowired
	public JobAdService(JobAdRepository jobRepo) {
		this.JobAdRepository = jobRepo;
	}

}