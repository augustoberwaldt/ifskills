package br.edu.ifrs.canoas.lds.ifskills.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.ifskills.domain.Document;
import br.edu.ifrs.canoas.lds.ifskills.domain.Post;
import br.edu.ifrs.canoas.lds.ifskills.domain.Rank;
import br.edu.ifrs.canoas.lds.ifskills.repository.DocumentRepository;
import br.edu.ifrs.canoas.lds.ifskills.repository.RankRepository;

@Service
public class DocumentService {
	
	
	private DocumentRepository documentRepository;
	private RankRepository rankRepository;
	
	@Autowired
	public DocumentService(DocumentRepository documentRepository, RankRepository rankRepository) {
		this.documentRepository = documentRepository;
		this.rankRepository = rankRepository;
	}

	public Document findOne(Document document) {
		document = documentRepository.findOne(document.getId());
		if (document instanceof Post) this.updateRank(document);
		return document;
	}
	
	public void updateRank(Document document) {
		List<Rank> ranks = rankRepository.findAllByDocument(document);
		Rank rank = null;
		if (ranks == null || ranks.isEmpty()) {
			ranks = new ArrayList<Rank>();
			rank = new Rank();
			rank.setRank(1);
			rank.setDocument(document);
		} else {
			rank = ranks.get(0);
			int val = rank.getRank() + 1;
			rank.setRank(val);
		}
		rankRepository.save(rank);
	}
}
