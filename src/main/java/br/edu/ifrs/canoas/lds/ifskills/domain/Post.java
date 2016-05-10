package br.edu.ifrs.canoas.lds.ifskills.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Create - 30/04/16 - Ricardo - Class post
 * Modify - 10/05/16 - Ricardo - extends Document
 */
@Entity
public class Post extends Document {

	/**
	 * @date: May/06/2016 - @author: Edward Ramos
	 * @description: Title of the post
	 */
	@NotEmpty
	private String title;

	/**
	 * @author Luciane Date: 09/05/2016 Description: create attribute subject
	 */
	private String subject;

	/**
	 * 30/04/16 - Ricardo - Body
	 * 
	 * Modified by Luciane Date: 09/05/2016 Description: add notation type
	 * "TEXT"
	 */
	// @NotEmpty
	@Column(columnDefinition = "TEXT")
	private String body;

	/**
	 * @author Luciane Date: 09/05/2016 Description: create attribute tags
	 */
	@ElementCollection
	@Size(min = 1, max = 2)
	private List<String> tags;

	/**
	 * @author Luciane Date: 09/05/2016 Description: create attribute postedOn
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss aaa")
	private Date postedOn;

	/**
	 * 02/05/16 - Ricardo - Relationship between Post and User May/05/2016 -
	 * 
	 * Modified by: Edward Ramos - Change User author to Long author; ManyToOne
	 * don't work when i add a insert in data-h2
	 * 
	 * Modified by Luciane Date: 09/05/2016 Description:The relationship between
	 * User and Post can not be removed because it will affect many stories.
	 */

	@ManyToOne
	private User author;

	/**
	 * @author Luciane Date: 05/05/2016 Description: creating the list of
	 *         responsible post
	 */
	@OneToMany
	private List<User> responsible;

	/**
	 * @date: May/06/2016 - @author: Edward Ramos
	 * @description: The post must have comments of Site members;
	 *               "orphanRemoval" = when an Post is removed, the comments (of
	 *               the post) are removed too.
	 * 
	 *               Modified by Luciane Date: 09/05/2016 Description: Pessoal!
	 *               O relacionamento entre Post e Comment vai ter que ser
	 *               tratado de outra forma! Está explicado no Trello! Assim que
	 *               conseguirem implementar as soluções, por favor, vamos
	 *               apagar este comentário. Deixei esta lista abaixo para
	 *               lembrarmos de criar o relacionamento: Post -> Comment
	 */
	/*
	 * @OneToMany(mappedBy = "post", orphanRemoval = true, fetch =
	 * FetchType.EAGER) private List<PostComments> postComments;
	 */

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

	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}

	/*
	 * public List<PostComments> getPostComments() { return postComments; }
	 * 
	 * public void setPostComments(List<PostComments> postComments) {
	 * this.postComments = postComments; }
	 */

	public List<User> getResponsible() {
		return responsible;
	}

	public void setResponsible(List<User> responsible) {
		this.responsible = responsible;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
