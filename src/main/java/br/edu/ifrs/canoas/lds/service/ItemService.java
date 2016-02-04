package br.edu.ifrs.canoas.lds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.domain.Item;
import br.edu.ifrs.canoas.lds.repository.ItemRepository;

@Service
public class ItemService {

	private ItemRepository repo;
	
	@Autowired
	public ItemService(ItemRepository repo) {
		this.repo = repo;
	}
	
	public Iterable<Item> list() {
		return repo.findAll();
	}

	public Object get(Long id) {
		return repo.findOne(id);
	}

}
