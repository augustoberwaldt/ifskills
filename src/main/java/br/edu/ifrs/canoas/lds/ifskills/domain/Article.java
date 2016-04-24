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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
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
	
	/**
	 * Auhtor: Edward Ramos
	 * Date:Apr/12/2016
	 * Description: Define whether the article is private or not (Private or Public)
	 */
	@Column(columnDefinition = "boolean default true")
	private Boolean privateArticle;

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
	@OneToMany(mappedBy = "article", orphanRemoval=true, fetch=FetchType.EAGER)
	private List<Comment> comments;
		
	public List<ArticleRank> getArticleRank() {
		return articleRank;
	}

	public void setArticleRank(List<ArticleRank> articleRank) {
		this.articleRank = articleRank;
	}

	/**
	 * 20/04/16 - Ricardo - Relationship between article star rating.
	 */
	@OneToMany(mappedBy = "article", orphanRemoval=true, fetch=FetchType.EAGER)
	private List<ArticleRank> articleRank;

	@Lob
	private byte[] picture;


	/**
	 * Auhtor: Edson
	 * Date:04/08/2016
	 * Description: Date of available article.
	 * 	
	 */
	@Column(length = 10)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date startPublishingDate;
	
	
	/**
	 * Auhtor: Edson
	 * Date:04/08/2016
	 * Description: Date of expire article.
	 * 
	 */
	@Future
	@Column(length = 10)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date oldArticleDate;
	
	/**
	 * Auhtor: Edson
	 * Date:04/08/2016
	 * Description: Date of delete article.
	 *
	 */
	@Column(length = 10)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date stopPublishingDate;	
	
	
	/**
	 * Auhtor: Edson
	 * Date:22/08/2016
	 * Description: Indicate whether an article is publicly available.
	 */	
	@Column(columnDefinition = "boolean default true")
	private Boolean publiclyAvailable;
	
	public Boolean getPubliclyAvailable() {
		return publiclyAvailable;
	}

	public void setPubliclyAvailable(Boolean publiclyAvailable) {
		this.publiclyAvailable = publiclyAvailable;
	}

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

	public Date getStartPublishingDate() {
		return startPublishingDate;
	}

	public void setStartPublishingDate(Date startPublishingDate) {
		this.startPublishingDate = startPublishingDate;
	}

	public Date getOldArticleDate() {
		return oldArticleDate;
	}

	public void setOldArticleDate(Date oldArticleDate) {
		this.oldArticleDate = oldArticleDate;
	}

	public Date getStopPublishingDate() {
		return stopPublishingDate;
	}

	public void setStopPublishingDate(Date stopPublishingDate) {
		this.stopPublishingDate = stopPublishingDate;
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

	public Boolean getPrivateArticle() {
		return privateArticle;
	}

	public void setPrivateArticle(Boolean privateArticle) {
		this.privateArticle = privateArticle;
	}
	
}
