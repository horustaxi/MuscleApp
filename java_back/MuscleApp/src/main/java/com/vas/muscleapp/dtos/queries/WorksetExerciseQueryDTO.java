package com.vas.muscleapp.dtos.queries;

/**
 *
 * @author Vinícius
 */
public class WorksetExerciseQueryDTO {

	private Long id;
	private String seriesNumber;
	private String repetitionsNumber;
	// in seconds
	private Short restingTime;
	private String details;
	private String exerciseName;
	private char worksetLetter;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSeriesNumber() {
		return seriesNumber;
	}

	public void setSeriesNumber(String seriesNumber) {
		this.seriesNumber = seriesNumber;
	}

	public String getRepetitionsNumber() {
		return repetitionsNumber;
	}

	public void setRepetitionsNumber(String repetitionsNumber) {
		this.repetitionsNumber = repetitionsNumber;
	}

	public Short getRestingTime() {
		return restingTime;
	}

	public void setRestingTime(Short restingTime) {
		this.restingTime = restingTime;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public char getWorksetLetter() {
		return worksetLetter;
	}

	public void setWorksetLetter(char worksetLetter) {
		this.worksetLetter = worksetLetter;
	}

}
