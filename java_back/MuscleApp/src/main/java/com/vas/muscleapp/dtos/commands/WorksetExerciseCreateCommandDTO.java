package com.vas.muscleapp.dtos.commands;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Vinícius
 */
@Getter
@Setter
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

}
