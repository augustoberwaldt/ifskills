/**
 * @author:Edward Ramos
 * @date: May/06/2016
 * @description: Comments of the post. 
 */
package br.edu.ifrs.canoas.lds.ifskills.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class PostComments {
	/**
	 * @author:Edward Ramos
	 * @date: May/06/2016
	 * @description: Id of comment 
	 */
	@Id
	@GeneratedValue
	private Long id;
	
	/**
	 * @author:Edward Ramos
	 * @date: May/06/2016
	 * @description: text of the comment 
	 */
	@NotEmpty
	@Size(min = 1, max = 500)
	private String body;

	
	/**
	 * @author:Edward Ramos
	 * @date: May/06/2016
	 * @description: Author of the comment
	 */
	@OneToOne
	@JoinColumn(name = "author_user_id")
	private User author;

	/**
	 * @author:Edward Ramos
	 * @date: May/06/2016
	 * @description: Comments of the post. 
	 */
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post post;
	
	/**
	 * @date: May/06/2016 - @author: Edward Ramos
	 * @description: The comment can have  replies of Site members;
	 * 				 "orphanRemoval" =  when an Comment is removed, the replies (of the comment) are removed too.
	 */
	//@OneToMany(mappedBy = "postComments", orphanRemoval=true, fetch=FetchType.EAGER)
	//private List<PostReplyComment> postReplyComments;
	
	//Gets'n'Sets
	
	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
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

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}


}
