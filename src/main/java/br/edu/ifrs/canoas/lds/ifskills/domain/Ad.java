/**
 * @author: Fernando Sturzbecher
 * @date: 10/04/16
 * @description: Class for persistence of the Help Wanted Ad's
 */
package br.edu.ifrs.canoas.lds.ifskills.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

@Entity
public class Ad {
	@Id
	@GeneratedValue
	private Long id;

	@Size(min = 1, max = 255)
	private String description;

	@ElementCollection
	@Size(min = 1,max = 4)
	private List<String> tags;
	
	@Column(columnDefinition = "TEXT")
	private String info;

	@OneToOne
	private User employer;

	@OneToOne
	private Address location;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public User getEmployer() {
		return employer;
	}

	public void setEmployer(User employer) {
		this.employer = employer;
	}

	public Address getLocation() {
		return location;
	}

	public void setLocation(Address location) {
		this.location = location;
	}
}