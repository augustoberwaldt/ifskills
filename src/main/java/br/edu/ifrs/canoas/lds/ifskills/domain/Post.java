package br.edu.ifrs.canoas.lds.ifskills.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty
	private String body;

}
