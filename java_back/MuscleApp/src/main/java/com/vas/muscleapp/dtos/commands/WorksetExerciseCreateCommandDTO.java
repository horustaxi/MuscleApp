package com.vas.muscleapp.dtos.commands;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 *
 * @author Vinícius
 */
public class WorksetExerciseCreateCommandDTO {

	@Size(max = 50)
	private String seriesNumber;
	@NotEmpty
	@Size(max = 50)
	private String repetitionsNumber;
	// in seconds
	@Positive
	private Short restingTime;
	@Size(max = 200)
	private String details;
	private Long worksetId;

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

	public Long getWorksetId() {
		return worksetId;
	}

	public void setWorksetId(Long worksetId) {
		this.worksetId = worksetId;
	}

}
