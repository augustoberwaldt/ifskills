package br.edu.ifrs.canoas.lds.ifskills.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	 * @date: May/06/2016 - @author: Edward Ramos
	 * @description: Title of the post
	 */
	@NotEmpty
	private String title;
	
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
	 * May/05/2016 - Modified by: Edward Ramos - Change User author to Long author;
	 *                                           ManyToOne don't work when i add a insert in data-h2
	 */
	//@ManyToOne
	@JoinColumn(name = "user_id")
	private Long author;
	
	/**
	 * @author Luciane
	 * Date: 05/05/2016
	 * Description: creating the list of responsible post
	 */
	@OneToMany
	private List <User> responsible;
	
	/**
	 * @date: May/06/2016 - @author: Edward Ramos
	 * @description: The post must have comments of Site members;
	 * 				 "orphanRemoval" =  when an Post is removed, the comments (of the post) are removed too.
	 */
	@OneToMany(mappedBy = "post", orphanRemoval=true, fetch=FetchType.EAGER)
	private List<PostComments> postComments;
	
	//Gets'n'Sets
	public List<User> getResponsible() {
		return responsible;
	}

	public void setResponsible(List<User> responsible) {
		this.responsible = responsible;
	}

	public Long getAuthor() {
		return author;
	}

	public void setAuthor(Long author) {
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
