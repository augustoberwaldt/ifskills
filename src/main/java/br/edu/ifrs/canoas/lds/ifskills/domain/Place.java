package br.edu.ifrs.canoas.lds.ifskills.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Place {
	
	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private String type;
	@Enumerated(EnumType.STRING)
	private PlaceType placeType;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public PlaceType getPlaceType() {
		return placeType;
	}
	public void setPlaceType(PlaceType placeType) {
		this.placeType = placeType;
	}
}
	