package br.edu.ifrs.canoas.lds.ifskills.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Create - 30/04/16 - Ricardo - Class post Modify - 10/05/16 - Ricardo -
 * extends Document
 */
@Entity
public class Post extends Document {

	/**
	 * @date: May/06/2016 - @author: Edward Ramos
	 * @description: Title of the post
	 */
	private String title;

	/**
	 * @author Luciane Date: 09/05/2016 Description: create attribute subject
	 */
	private String subject;

	/**
	 * @author Luciane Date: 09/05/2016 Description: create attribute tags
	 */
	@ElementCollection
	@Size(min = 1, max = 2)
	private List<String> tags;

	/**
	 * @author Luciane Date: 05/05/2016 Description: creating the list of
	 *         responsible post
	 */
	@OneToMany
	private List<User> responsible;

	/**
	 * @author Luciane da Silva
	 * @date: 12/05/2016
	 * @description: attribute to set post status (public or private)
	 * @return
	 */
	public Boolean isPublic;

	/**
	 * @author Felipe
	 * @date: 12/05/2016
	 * @description: attribute to make a relatioship with Rank
	 * 
	 * Modified by: Luciane
	 * @date: 13/05/2016
	 * @description: added JPA cascade mapping
	 * 
	 * Modified by: Luciane
	 * @date: 15/05/2016
	 * @description: modified JPA cascade for merge
	 */
	
	@ManyToOne(cascade = {CascadeType.MERGE})//revisar isso
	private Rank rank;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public List<User> getResponsible() {
		return responsible;
	}

	public void setResponsible(List<User> responsible) {
		this.responsible = responsible;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

}
