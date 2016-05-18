package br.edu.ifrs.canoas.lds.ifskills.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Felipe Description: class to secure the value of evaluation of the
 *         post Date:11/05/2016
 */
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Rank {
	@Id
	@GeneratedValue
	private Long id;

	/**
	 * Modified by: Luciane
	 * 
	 * @date: 13/05/2016
	 * @description: added JPA cascade mapping
	 * 
	 * Modified by: Luciane
	 * @date: 15/05/2016
	 * @description: modified JPA cascade for merge
	 */
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "document_id")
	//@NotNull
	private Document document;

	@NotNull
	private Float rank;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Float getValue() {
		return rank;
	}

	public void setValue(Float rank) {
		this.rank = rank;
	}

}
