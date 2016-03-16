package br.edu.ifrs.canoas.lds.ifskills.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.edu.ifrs.canoas.lds.ifskills.IFSkillsApplication;
import br.edu.ifrs.canoas.lds.ifskills.domain.Item;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(IFSkillsApplication.class)
public class ItemServiceTest {

	@Autowired
	ItemService itemService;

	@Test
	public void testList() {
		assertTrue(itemService.list().spliterator().estimateSize() > 0);
	}

	@Test
	public void testGet() {
		assertThat(itemService.get(1L), hasProperty("name", is("Celular")));
	}

	@Test
	public void testSave() {
		Item item = new Item();
		item.setName("My Name");
		assertThat(itemService.save(item), hasProperty("id", is(not(empty()))));
	}

	@Test
	public void testDelete() {
		assertThat(itemService.get(2L), hasProperty("name", is("Caneta")));
		itemService.delete(2L);
		assertThat(itemService.get(2L), is(nullValue()));
	}

}
