/**
 * @author:Luciane
 * @date: 27/03/2016
 * @description: 
 */
package br.edu.ifrs.canoas.lds.ifskills.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Modify - 10/05/16 - Ricardo - extends Document
 */
@Entity
public class Comment extends Document {

	@ManyToOne
	@JoinColumn(name = "document_id", nullable = true)
	private Document document;

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

}
