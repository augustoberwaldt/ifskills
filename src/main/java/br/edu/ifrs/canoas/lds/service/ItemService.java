package br.edu.ifrs.canoas.lds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.domain.Item;
import br.edu.ifrs.canoas.lds.repository.ItemRepository;

@Service
public class ItemService {

	private ItemRepository itemRepository;
	
	@Autowired
	public ItemService(ItemRepository repo) {
		this.itemRepository = repo;
	}
	
	public Iterable<Item> list() {
		return itemRepository.findAll();
	}

	public Item get(Long id) {
		return itemRepository.findOne(id);
	}

	public Item save(Item item) {
		return itemRepository.save(item);
	}

	public void delete(Long id) {
		itemRepository.delete(id);
	}

}
