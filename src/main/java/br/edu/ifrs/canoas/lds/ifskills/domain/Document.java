package br.edu.ifrs.canoas.lds.ifskills.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Create - 10/05/16 - Ricardo - Document Superclass
 **/
@MappedSuperclass
public abstract class Document {

	/**
	 * Create - 10/05/16 - Ricardo - Id
	 */
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * Create - 30/04/16 - Ricardo - Body 
	 * Modify - Luciane Date: 09/05/2016
	 * Description: add notation type "TEXT"
	 */
	// @NotEmpty
	@Column(columnDefinition = "TEXT")
	private String body;

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
