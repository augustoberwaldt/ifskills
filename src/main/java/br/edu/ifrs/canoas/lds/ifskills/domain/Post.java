package br.edu.ifrs.canoas.lds.ifskills.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 30/04/16 - Ricardo - Class post
 */
@Entity
public class Post {

	/**
	 * 30/04/16 - Ricardo - Id
	 */
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * 30/04/16 - Ricardo - Body
	 */
	@NotEmpty
	private String body;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
