/**
 * @author:Luciane
 * @date: 27/03/2016
 * @description: 
 */
package br.edu.ifrs.canoas.lds.ifskills.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Modify - 10/05/16 - Ricardo - extends Document
 */
@Entity
public class Comment extends Document {

	@NotEmpty
	@Size(min = 1, max = 500)
	private String content;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date postedOn;

	/**
	 * Auhtor: Luciane Date:27/03/2016 Description: Relationship between Comment
	 * and User The author of a review is a type attribute User
	 */
	@OneToOne
	@JoinColumn(name = "author_user_id")
	private User author;

	/**
	 * Auhtor: Luciane Date:27/03/2016 Description: Relationship between Comment
	 * and Article The Article type attribute will store the id of the article
	 * to which the comment refers
	 */
	@ManyToOne
	@JoinColumn(name = "article_id", nullable = true)
	private Article article;

	/**
	 * @date: May/10/2016 - @author: Edward Ramos
	 */
	@ManyToOne
	@JoinColumn(name = "post_id", nullable = true)
	private Post post;

	@ManyToOne
	@JoinColumn(name = "comment_id", nullable = true)
	private Comment comment;

	@OneToMany(mappedBy = "comment", orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Comment> comments;

	// Gets'n'Sets

	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
