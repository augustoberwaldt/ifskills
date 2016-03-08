package br.edu.ifrs.canoas.lds.ifskills.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "places")
public class Place {
	
@Id
@Column (name = "id_place")
@GeneratedValue
private Long id;

@Column ( nullable = false )
private String street;

@Column ( nullable = false )
private Long number;

@Column 
private String complement;

@OneToOne(mappedBy="place")
private User user;


public Long getId() {
	return id;
}

public String getStreet() {
	return street;
}

public void setStreet(String street) {
	this.street = street;
}
public Long getNumber() {
	return number;
}
public void setNumber(Long number) {
	this.number = number;
}
public String getComplement() {
	return complement;
}
public void setComplement(String complement) {
	this.complement = complement;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}



}