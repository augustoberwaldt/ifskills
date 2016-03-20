package br.edu.ifrs.canoas.lds.ifskills.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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

	//Edson
	@Column(columnDefinition = "boolean default false")
	private Boolean isPrivate;
	//EndEdson
	
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

	private User() {
		this.active=true;
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
	//Fernando
	public TrainerApplication getTrainerApplication() {return trainerApplication;}
	public void setTrainerApplication(TrainerApplication trainerApplication) {this.trainerApplication = trainerApplication;}
//End Fernando
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + "]";
	}

	public Boolean getIsPrivate() {
		return isPrivate;
	}

	public void setIsPrivate(Boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

}
