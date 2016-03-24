/*
 * 
 */
package br.edu.ifrs.canoas.lds.ifskills.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Item {

	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty
	private String name;
	@Column(length = 255)
	@Size(min = 1, max = 255)
	private String description;
	@Column(columnDefinition = "boolean default true")
	private Boolean active;
	@Past
	@Temporal(TemporalType.DATE)
	@DateTimeFormat (pattern="dd/MM/yyyy")
	private Date date;	

	public Item() {
		this.active=true;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Boolean getActive() {
		return active;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
}
