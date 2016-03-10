package br.edu.ifrs.canoas.lds.ifskills.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Course {

@Id
@GeneratedValue
private Long id;

@ManyToOne
@JoinColumn (name = "id_type")
private CourseType type;

@NotEmpty
private String name;

//This type is temporary. It has to be HTML.
@Column(length = 255)
@Size(min = 1, max = 255)
private String description;


//Trainer names (multiple selection from a list) ??????????
//***Find this option (multiple section list) on template?***


@Temporal(TemporalType.DATE)
@DateTimeFormat (pattern="dd/MM/yyyy")
private Date startDate;

@Temporal(TemporalType.DATE)
@DateTimeFormat (pattern="dd/MM/yyyy")
private Date endDate;	


//DON'T KNOW IF (instructor) AND (contact) ARE THE SAME PERSON; I ASSUMED THEY'RE. 

//PLACE+CONTACT INFO = USER ATTRIBUTES.
@OneToOne 
@JoinColumn (name = "contact_id")
private User contactInfo;

//DID'NT FIND THE ENTITY "ATTENDEE", SO I PUT IN THIS WAY:
@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
@JoinTable( 
	name = "course_attendees", 
	joinColumns = {@JoinColumn(name="user_id")}, 
	inverseJoinColumns = {@JoinColumn(name="id_course")}  
)
private Set<User> attendees = new HashSet<User>();

public Long getId() {
	return id;
}


public User getContactInfo() {
	return contactInfo;
}

public void setContactInfo(User contactInfo) {
	this.contactInfo = contactInfo;
}


public Set<User> getAttendees() {
	return attendees;
}

public void setAttendees(Set<User> attendees) {
	this.attendees = attendees;
}

public void setId(Long id) {
	this.id = id;
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

public Date getStartDate() {
	return startDate;
}

public void setStartDate(Date startDate) {
	this.startDate = startDate;
}

public Date getEndDate() {
	return endDate;
}

public void setEndDate(Date endDate) {
	this.endDate = endDate;
}
}