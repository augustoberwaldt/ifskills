/**
 * @author:
 * @date: 
 * @description: 
 */
package br.edu.ifrs.canoas.lds.ifskills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifrs.canoas.lds.ifskills.domain.Item;
import br.edu.ifrs.canoas.lds.ifskills.repository.ItemRepository;

// TODO: Auto-generated Javadoc
@Service
public class ItemService {

	private ItemRepository itemRepository;
	
	/**
	 * Instantiates a new item service.
	 *
	 * @param repo
	 *            the repo
	 */
	@Autowired
	public ItemService(ItemRepository repo) {
		this.itemRepository = repo;
	}
	
	/**
	 * List.
	 *
	 * @return the iterable
	 */
	public Iterable<Item> list() {
		return itemRepository.findAll();
	}

	/**
	 * Gets the.
	 *
	 * @param id
	 *            the id
	 * @return the item
	 */
	public Item get(Long id) {
		return itemRepository.findOne(id);
	}

	/**
	 * Save.
	 *
	 * @param item
	 *            the item
	 * @return the item
	 */
	public Item save(Item item) {
		return itemRepository.save(item);
	}

	/**
	 * Delete.
	 *
	 * @param id
	 *            the id
	 */
	public void delete(Long id) {
		itemRepository.delete(id);
	}

}
