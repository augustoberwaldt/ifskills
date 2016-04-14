/**
 * @author: Fernando
 * @date: 24/03/16
 * @description: The application to become a trainer is here.
 */

package br.edu.ifrs.canoas.lds.ifskills.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class TrainerApplication {
	@Id
	@GeneratedValue
	private Long id;
	@Size(min = 1, max = 255)
	private String briefSummary;
	@Size(min = 1, max = 255)
	private String justification;
	@Size(min = 1, max = 255)
	private String realWorldTraining;
	@Size(min = 1, max = 255)
	private String references;
	@Enumerated(EnumType.STRING)
	private Status status;

	// Get's and Set's By:Edward Ramos
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBriefSummary() {
		return briefSummary;
	}

	public void setBriefSummary(String briefSummary) {
		this.briefSummary = briefSummary;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public String getRealWorldTraining() {
		return realWorldTraining;
	}

	public void setRealWorldTraining(String realWorldTraining) {
		this.realWorldTraining = realWorldTraining;
	}

	public String getReferences() {
		return references;
	}

	public void setReferences(String references) {
		this.references = references;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}