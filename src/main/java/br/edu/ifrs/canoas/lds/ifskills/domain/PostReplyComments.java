/**
 * @author:Edward Ramos
 * @date: May/06/2016
 * @description: Replies of the reply. 
 */
package br.edu.ifrs.canoas.lds.ifskills.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class PostReplyComments {
	/**
	 * @author:Edward Ramos
	 * @date: May/06/2016
	 * @description: Id of reply 
	 */
	@Id
	@GeneratedValue
	private Long id;
	
	/**
	 * @author:Edward Ramos
	 * @date: May/06/2016
	 * @description: text of the reply 
	 */
	@NotEmpty
	@Size(min = 1, max = 500)
	private String body;

	
	/**
	 * @author:Edward Ramos
	 * @date: May/06/2016
	 * @description: Author of the reply
	 */
	@OneToOne
	@JoinColumn(name = "author_user_id")
	private User author;

	/**
	 * @author:Edward Ramos
	 * @date: May/06/2016
	 * @description: Comments of the reply. 
	 */
	@ManyToOne
	@JoinColumn(name = "post_id")
	private PostComments postComments;
	
	/**
	 * @date: May/06/2016 - @author: Edward Ramos
	 * @description: The reply can have  replies of Site members;
	 * 				 "orphanRemoval" =  when a reply is removed, the replies (of the reply) are removed too.
	 */
	//@OneToMany(mappedBy = "replyComments", orphanRemoval=true, fetch=FetchType.EAGER)
	//private List<PostReplyComments> postReplyComments;
	
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

	

}
