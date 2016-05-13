package br.edu.ifrs.canoas.lds.ifskills.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.edu.ifrs.canoas.lds.ifskills.IFSkillsApplication;
import br.edu.ifrs.canoas.lds.ifskills.domain.Document;
import br.edu.ifrs.canoas.lds.ifskills.domain.Post;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(IFSkillsApplication.class)
public class RankServiceTest {

	@Autowired
	DocumentService docService;
	
	@Test
	public void testToCheckThePostRank() {
		Document document = new Post();
		document.setId(1L);
		docService.findOne(document);
	}

}
