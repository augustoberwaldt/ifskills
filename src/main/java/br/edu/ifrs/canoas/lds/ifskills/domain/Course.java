/**
 * @author:
 * @date: 
 * @description: 
 */
package br.edu.ifrs.canoas.lds.ifskills.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Course {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty
	private String name;
	
	// This type is temporary. It has to be HTML.
	@Size(min = 1, max = 255)
	private String description;
	
	@NotNull
	private Long workload;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date endDate;
	
	@OneToOne
	@JoinColumn(name = "instructor_user_id")
	private User instructor;
	
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "course_attendees", joinColumns = { @JoinColumn(name = "course_id") }, inverseJoinColumns = {
			@JoinColumn(name = "attendee_user_id") })
	private Set<User> attendees = new HashSet<User>();	
	
	public Long getId() {
		return id;
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
	public Long getWorkload() {
		return workload;
	}
	public void setWorkload(Long workload) {
		this.workload = workload;
	}
	public User getInstructor() {
		return instructor;
	}
	public void setInstructor(User instructor) {
		this.instructor = instructor;
	}
	public Set<User> getAttendees() {
		return attendees;
	}
	public void setAttendees(Set<User> attendees) {
		this.attendees = attendees;
	}
}