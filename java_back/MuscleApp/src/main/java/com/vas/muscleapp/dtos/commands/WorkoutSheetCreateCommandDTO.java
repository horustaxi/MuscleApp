package com.vas.muscleapp.dtos.commands;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author Vinícius
 */
public class WorkoutSheetCreateCommandDTO {

	@NotEmpty
	@Size(max = 100)
	private String description;
	private Long workoutPlanId;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getWorkoutPlanId() {
		return workoutPlanId;
	}

	public void setWorkoutPlanId(Long workoutPlanId) {
		this.workoutPlanId = workoutPlanId;
	}

}
