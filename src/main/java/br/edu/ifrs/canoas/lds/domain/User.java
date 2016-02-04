package br.edu.ifrs.canoas.lds.domain;

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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.hibernate.validator.constraints.Email;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity
@Table( name="users" )
public class User {

	@Id @GeneratedValue
	private Long id;
	
	@Column( unique=true, nullable=false )
	@Email
	private String email;
	
	@Column( nullable=false )
	private String password;

	@Column( nullable=false )
	private String fullName;
	
	@Lob @Column(name="PIC")
	private byte[] picture;
	
	@ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
	@JoinTable( 
		name = "users_roles", 
		joinColumns = {@JoinColumn(name="user_id")}, 
		inverseJoinColumns = {@JoinColumn(name="role_id")}  
	)
	private Set<Role> roles = new HashSet<Role>();
	
	private User() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
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
	
	public String getPictureBase64(){
		StringBuilder sb = new StringBuilder();
		sb.append("data:image/png;base64,");
		sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(picture, false)));
		return sb.toString();
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + "]";
	}

	
}
