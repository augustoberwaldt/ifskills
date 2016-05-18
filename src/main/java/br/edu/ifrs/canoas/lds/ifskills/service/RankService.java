package br.edu.ifrs.canoas.lds.ifskills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.ifskills.repository.DocumentRepository;
import br.edu.ifrs.canoas.lds.ifskills.repository.RankRepository;

/**
 * 
 * @author Felipe 
 * @Date:11/05/2016
 * 
 */
@Service
public class RankService {

	@SuppressWarnings("unused")
	private DocumentRepository documentRepository;
	@SuppressWarnings("unused")
	private RankRepository rankRepository;

	@Autowired
	public RankService(RankRepository rankRepository, DocumentRepository documentRepository) {
		this.rankRepository = rankRepository;
		this.documentRepository = documentRepository;
	}

}
