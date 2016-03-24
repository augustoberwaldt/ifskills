
package br.edu.ifrs.canoas.lds.ifskills.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class TrainerApplication {
	@Id
	@GeneratedValue
	private Long id;
	@Size(min = 1, max = 255)
	private String briefSummary;
	@Size(min = 1, max = 255)
	private String justification;
	@Size(min = 1, max = 255)
	private String realWorldTraining;
	@Size(min = 1, max = 255)
	private String references;
	@Enumerated(EnumType.STRING)
	private TrainerApplicationStatus status;
}