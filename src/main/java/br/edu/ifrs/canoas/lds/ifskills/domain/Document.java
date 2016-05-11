package br.edu.ifrs.canoas.lds.ifskills.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Create - 10/05/16 - Ricardo - Document abstract superclass
 **/
@MappedSuperclass
public abstract class Document {

	/**
	 * Create - 10/05/16 - Ricardo - Id
	 */
	@Id
	@GeneratedValue
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
