package br.edu.ifrs.canoas.lds.ifskills.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	/**
	 * 02/05/16 - Ricardo - Hidden
	 */
	@Column(columnDefinition = "boolean default false")
	private Boolean hidden;

	/**
	 * 02/05/16 - Ricardo - Relationship between Post and User
	 */
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User author;

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Boolean getHidden() {
		return hidden;
	}

	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}

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
