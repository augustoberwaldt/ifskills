/**
 * @author: Fernando Sturzbecher
 * @date: 10/04/16
 * @updated: 11/04/16
 * @renamed: 12/04/16
 * @description: Class for persistence of the Help Wanted Ad's
 */
package br.edu.ifrs.canoas.lds.ifskills.domain;

import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class JobAd {
	@Id
	@GeneratedValue
	private Long id;

	@Size(min = 1, max = 255)
	private String description;

	@ElementCollection
	@Size(min = 1,max = 4)
	private List<String> tags;
	
	@NotEmpty
	private String requirements;
	
	@NotEmpty
	private String businessArea;

	@OneToOne
	private User employer;

	@OneToOne
	private Address location;
	
	@NotEmpty
	private String educationLevelRequired;
	
	@NotEmpty
	private String benefits;
	
	@NotEmpty
	private String contactInfo;

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

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public String getBusinessArea() {
		return businessArea;
	}

	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
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

	public String getEducationLevelRequired() {
		return educationLevelRequired;
	}

	public void setEducationLevelRequired(String educationLevelRequired) {
		this.educationLevelRequired = educationLevelRequired;
	}

	public String getBenefits() {
		return benefits;
	}

	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
}