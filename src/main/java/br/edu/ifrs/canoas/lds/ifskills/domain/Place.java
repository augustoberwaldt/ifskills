/*
 * 
 */
package br.edu.ifrs.canoas.lds.ifskills.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Place {

	@Id
	@GeneratedValue
	private Long id;
	private String description;
	@Enumerated(EnumType.STRING)
	private PlaceType placeType;
	@OneToOne
	//@JoinColumn(name = "parent_place_id")
	private Place parentPlace;
	
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

	public PlaceType getPlaceType() {
		return placeType;
	}

	public void setPlaceType(PlaceType placeType) {
		this.placeType = placeType;
	}

	public Place getParentPlace() {
		return parentPlace;
	}

	public void setParentPlace(Place parentPlace) {
		this.parentPlace = parentPlace;
	}

}