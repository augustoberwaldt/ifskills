package br.edu.ifrs.canoas.lds.ifskills.domain;
//Author: Fernando - 18/03/16

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class TrainerApplication {
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	private TrainerApplicationStatus status;
	
	@OneToOne
	private Scholarity scholarity;
	
	@Size(min = 1, max = 255)
	private String educationDescription;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Date graduationDate;

	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	public void setStatus(TrainerApplicationStatus status){this.status = status;}
	public TrainerApplicationStatus getStatus() {return status;}
	public Scholarity getScholarity() {return scholarity;}
	public void setScholarity(Scholarity scholarity) {this.scholarity = scholarity;}
	public String getEducationDescription() {return educationDescription;}
	public void setEducationDescription(String educationDescription) {this.educationDescription = educationDescription;}
	public Date getGraduationDate() {return graduationDate;}
	public void setGraduationDate(Date graduationDate) {this.graduationDate = graduationDate;}	
}