/*
 * 
 */
package br.edu.ifrs.canoas.lds.ifskills.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Email;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Base64Utils;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true, nullable = false)
	@Email
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String fullName;
	
	@Column(columnDefinition = "TEXT")
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// 03-04-2016 - Edson - Changed attribute name
	@Column(columnDefinition = "boolean default false")
	private Boolean privateProfile;
	// EndEdson

	@Lob
	private byte[] picture;

	// inserção do relacionamento com a classe Address
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })

	private Set<Role> roles = new HashSet<Role>();

	@Column(columnDefinition = "boolean default true")
	private Boolean active;
	
	@OneToOne
	private TrainerApplication trainerApplication;
	
	//@OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	//private List<JobAd> jobs;

	//public List<JobAd> getJobs() {
	//	return jobs;
	//}

	//public void setJobs(List<JobAd> jobs) {
	//	this.jobs = jobs;
	//}

	public User() {
		this.active = true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public Boolean getActive() {
		return active;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setPassword(String password) {
		this.password = new BCryptPasswordEncoder().encode(password);
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public byte[] getPicture() {
		return picture;
	}

	public String getPictureBase64() {
		return "data:image/png;base64," + Base64Utils.encodeToString(picture);
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + "]";
	}

	/**
	 * Checks if is private.
	 *
	 * @return the boolean
	 */
	public Boolean getPrivateProfile() {
		return privateProfile;
	}

	public void setPrivateProfile(Boolean privateProfile) {
		this.privateProfile = privateProfile;
	}
	
	// Edson - 03-04-2016 - Create method getShowProfileDetails() 
	public Boolean getShowProfileDetails(){
		//UserService --> Verify if is ADM,  return true, 
		//else return userProfile
		//(sec:authorize="hasRole('ROLE_ADMIN')"? return true : return false);
		//UserProfileService.this.getPrincipal().getUser().getRoles();
		return privateProfile;		
	}
	//EndEdson
}
