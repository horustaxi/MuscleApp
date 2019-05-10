package com.vas.muscleapp.dtos;

/**
 *
 * @author Vinícius
 */
public class WorkoutPlanDTO {

	private Long id;
	private String description;
	private String createdByName;
	private String createdById;
	private String createdToId;
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

	public String getCreatedById() {
		return createdById;
	}

	public void setCreatedById(String createdById) {
		this.createdById = createdById;
	}

	public String getCreatedToId() {
		return createdToId;
	}

	public void setCreatedToId(String createdToId) {
		this.createdToId = createdToId;
	}

	public String getCreatedToName() {
		return createdToName;
	}

	public void setCreatedToName(String createdToName) {
		this.createdToName = createdToName;
	}

}
