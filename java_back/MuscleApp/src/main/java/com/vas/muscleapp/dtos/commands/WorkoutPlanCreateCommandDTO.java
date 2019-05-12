package com.vas.muscleapp.dtos.commands;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author Vinícius
 */
public class WorkoutPlanCreateCommandDTO {

	@NotEmpty
	@Size(max = 100)
	private String description;
	private Long createdByUserId;
	private Long createdToUserId;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCreatedByUserId() {
		return createdByUserId;
	}

	public void setCreatedByUserId(Long createdByUserId) {
		this.createdByUserId = createdByUserId;
	}

	public Long getCreatedToUserId() {
		return createdToUserId;
	}

	public void setCreatedToUserId(Long createdToUserId) {
		this.createdToUserId = createdToUserId;
	}

}
