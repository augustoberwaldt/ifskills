package br.edu.ifrs.canoas.lds.ifskills.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Course {

@Id
@GeneratedValue
private Long id;

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

//This type is temporary. It has to be HTML.
@Column
private String venueName;

@Column
private String venueAddress;

//Not sure if those attributes have to be created in this way.
@Column
@NotEmpty
private String contactName;

@Column 
private String contactPhone;

@Column
@Email
private String contactEmail;

	
}
