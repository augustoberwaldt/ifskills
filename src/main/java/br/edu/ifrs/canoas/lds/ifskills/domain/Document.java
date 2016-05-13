package br.edu.ifrs.canoas.lds.ifskills.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Create - 10/05/16 - Ricardo - Document Superclass
 **/
@Inheritance(strategy=InheritanceType.JOINED)
@Entity
public abstract class Document {	
	
	@OneToMany
	private List<Comment> comments;

	/**
	 * Create - 10/05/16 - Ricardo - Id
	 */
	@Id
	@GeneratedValue
	private Long id;
	
	/**
	 * @author Luciane
	 * Date: 11/05/2016
	 * Description: Relationship between Docment
	 * and User 
	 */
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User author;

	/**
	 * Create - 30/04/16 - Ricardo - Body 
	 * Modify - Luciane Date: 09/05/2016
	 * Description: add notation type "TEXT"
	 */
	//@NotEmpty
	@Column(columnDefinition = "TEXT")
	private String body;
	
	/**
	 * @author Luciane
	 * Date: 11/05/2016
	 * Description: Document posting date
	 */
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date postedOn;
	
	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}

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
	
	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
}
