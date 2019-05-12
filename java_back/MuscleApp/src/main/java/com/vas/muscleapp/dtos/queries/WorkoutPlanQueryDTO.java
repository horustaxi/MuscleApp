package com.vas.muscleapp.dtos.queries;

/**
 *
 * @author Vinícius
 */
public class WorkoutPlanQueryDTO {

	private Long id;
	private String description;
	private String createdByName;
	private Long createdById;
	private Long createdToId;
	private String createdToName;

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

	public String getCreatedByName() {
		return createdByName;
	}

	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}

	public Long getCreatedById() {
		return createdById;
	}

	public void setCreatedById(Long createdById) {
		this.createdById = createdById;
	}

	public Long getCreatedToId() {
		return createdToId;
	}

	public void setCreatedToId(Long createdToId) {
		this.createdToId = createdToId;
	}

	public String getCreatedToName() {
		return createdToName;
	}

	public void setCreatedToName(String createdToName) {
		this.createdToName = createdToName;
	}

}
