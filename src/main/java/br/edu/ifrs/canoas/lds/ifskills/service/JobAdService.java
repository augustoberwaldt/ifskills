/**
 * @author:
 * @date: 
 * @description: 
 */
package br.edu.ifrs.canoas.lds.ifskills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.ifskills.domain.JobAd;
import br.edu.ifrs.canoas.lds.ifskills.repository.JobAdRepository;

// TODO: Auto-generated Javadoc
@Service
public class JobAdService {

	private JobAdRepository jobAdRepository;

	/**
	 * Instantiates a new article service.
	 *
	 * @param artRepo
	 *            the art repo
	 */
	@Autowired
	public JobAdService(JobAdRepository jobRepo) {
		this.jobAdRepository = jobRepo;
	}
	
	/**
	 * @author Luciane
	 * Date: 14/04/2016
	 * Description: Method List.
	 * @return the iterable
	 */
	public Iterable<JobAd> list() {
		return jobAdRepository.findAll();
	}
	
	/**
	 * @author Luciane
	 * Date: 14/04/2016
	 * Description: Method Delete.
	 *
	 * @param id
	 *            the id
	 */
	public void delete(Long id) {
		jobAdRepository.delete(id);
	}
	
	/**
	 * @author Luciane
	 * Date: 14/04/2016
	 * Description: Method Gets the.
	 *
	 * @param id
	 *            the id
	 * @return the article
	 */
	public JobAd get(Long id) {
		return jobAdRepository.findOne(id);
	}

}