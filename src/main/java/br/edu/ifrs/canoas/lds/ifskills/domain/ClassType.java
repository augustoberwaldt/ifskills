package br.edu.ifrs.canoas.lds.ifskills.domain;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class ClassType {
	
	@Id
	@Column (name = "id_type")
	@GeneratedValue
	private int type;
	
	@Column (name = "type_name")
	private String typeName;
	
	@Column (name = "description",length = 255)
	@Size(min = 1, max = 255)
	private String description;
	
	@OneToMany (mappedBy="type")
	private Collection<Class> classes;

	
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
