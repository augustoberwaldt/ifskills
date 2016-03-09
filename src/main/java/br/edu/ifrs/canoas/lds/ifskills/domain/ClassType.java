package br.edu.ifrs.canoas.lds.ifskills.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

public class ClassType {
	
	@Id
	@Column (name = "id_type")
	@GeneratedValue
	private int type;
	
	@Column (name = "description",length = 255)
	@Size(min = 1, max = 255)
	private String description;

	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
