package br.edu.ifrs.canoas.lds.ifskills.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
/**
 * 
 * @author Felipe
 * Description: class to secure the value of evaluation of the post
 * Date:11/05/2016
 */
@Entity
public class PostRank {
		@Id
		@GeneratedValue
		private Long id;	
		
		@OneToOne
		@JoinColumn(name = "post_id")
		private Post post;
		
		@NotEmpty
		@Size(min = 0, max = 5)
		private float rank;
		
		private int views;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public float getRank() {
			return rank;
		}

		public void setRank(float rank) {
			this.rank = rank;
		}

		public int getViews() {
			return views;
		}
		
		public void setViews(int views){
			this.views = views;
		}
}
