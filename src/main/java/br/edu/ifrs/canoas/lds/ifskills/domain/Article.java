/**
 * @author:Luciane
 * @date: 24/03/2016
 * @description: Class Article
 * 
 * @author: Felipe
 * @date:03/04/2016
 * @description: changed keywords to tags
 * 
 * */
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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.Base64Utils;

@Entity
public class Article {
	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty
	private String title;

	private String slug;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss aaa")
	private Date postedOn;

	@ElementCollection
	@Size(min = 1,max = 2)
	private List<String> tags;

	private Boolean active;

	/**
	 * Auhtor: Luciane
	 * Date:24/03/2016
	 * Description: Relacionamento entre Article e User
	 * Author is a type attribute User
	 * A user can be the author of several articles
	 */
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User author;

	@Column(columnDefinition = "TEXT")
	@Size(min = 1, max = 500)
	private String teaser;

	//@NotEmpty
	@Column(columnDefinition = "TEXT")
	private String body;

	/**
	 * Author: Luciane
	 * Date:27/03/2016
	 * Description: Relationship between Article and Comment
	 * An article has a comments list
	 * 
	 * Date: 05/04/2016
	 * Modified by Aline G.
	 * Description: "orphanRemoval" added so when an Article is removed, 
	 * it's comments are removed too.
	 */
	@OneToMany(mappedBy = "article", orphanRemoval=true)
	private List<Comment> comments;

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

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
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

	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
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
