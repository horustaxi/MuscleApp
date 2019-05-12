package com.vas.muscleapp.dtos.queries;

/**
 *
 * @author Vinícius
 */
public class WorkoutSheetQueryDTO {

	private Long id;
	private String description;
	private String workoutPlanDescription;

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

	public String getWorkoutPlanDescription() {
		return workoutPlanDescription;
	}

	public void setWorkoutPlanDescription(String workoutPlanDescription) {
		this.workoutPlanDescription = workoutPlanDescription;
	}

}
