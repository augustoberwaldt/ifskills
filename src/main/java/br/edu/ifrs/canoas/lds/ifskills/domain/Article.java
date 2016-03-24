/**
 * @author:
 * @date: 
 * @description: 
 */
package br.edu.ifrs.canoas.lds.ifskills.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.Base64Utils;

@Entity
public class Article {
	@Id @GeneratedValue
	private Long id;

	@NotEmpty
	private String title;

	@NotEmpty
	private String slug;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat ( pattern="dd/M/yyyy hh:mm:ss a")
	private Date postedOn;   
	
	@Size(min=1, max=2)
	@ElementCollection
	private List<String> keywords;
	
	private Boolean active;
	
	//relacionamento com USER
	@NotNull
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User author;
	
	@Column(columnDefinition = "TEXT")
	private String teaser;

	@NotEmpty
	@Column(columnDefinition = "TEXT")
	private String body;

	// relacionamento com COMMENTS
	@OneToOne
	@JoinColumn(name = "comment_id")
	private Comment comment;
	
	@Lob
	private byte[] picture;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getTeaser() {
		return teaser;
	}

	public void setTeaser(String teaser) {
		this.teaser = teaser;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public byte[] getPicture() {
		return picture;
	}
	
	public String getPictureBase64() {
		return "data:image/png;base64," + Base64Utils.encodeToString(picture);
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
	


}
